package org.instantlogic.engine.presence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.instantlogic.engine.TravelerProxy;
import org.instantlogic.engine.manager.CaseManager;
import org.instantlogic.engine.manager.Update;
import org.instantlogic.engine.presence.placetemplate.TravelerPlaceTemplate;
import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.util.CaseAdministration;
import org.instantlogic.fabric.util.Observations;
import org.instantlogic.fabric.util.ObservationsOutdatedObserver;
import org.instantlogic.fabric.util.ValueChangeEvent;
import org.instantlogic.fabric.util.ValueChangeObserver;
import org.instantlogic.fabric.value.ReadOnlyAttributeValue;
import org.instantlogic.interaction.Application;
import org.instantlogic.interaction.flow.InvalidFlowCoordinatesException;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.util.FlowContext;
import org.instantlogic.interaction.util.HistoryExtension;
import org.instantlogic.interaction.util.LocationInfo;
import org.instantlogic.interaction.util.RenderContext;
import org.instantlogic.interaction.util.TravelerInfo;

/**
 * Represents a traveler in the Presence application. Returning messages is possible through the TravelerProxy.
 */
public class Traveler extends AbstractTraveler implements HistoryExtension {

  private static final Map<String, Object> PLACE_NOT_FOUND = new LinkedHashMap<String, Object>();

  static {
    PLACE_NOT_FOUND.put("id", "1");
    PLACE_NOT_FOUND.put("type", "Page");
    PLACE_NOT_FOUND.put("pageType", "error");
    PLACE_NOT_FOUND.put("reason", "notfound");
  }

  private class Subscription {

    private boolean placeOutdated = true;
    private final String location;

    private ObservationsOutdatedObserver placeOutdatedObserver;
    private final ValueChangeObserver placeOutdatedValueChangeObserver = new ValueChangeObserver() {
      @Override
      public void valueChanged(ValueChangeEvent event) {
        placeOutdated = true;
        placeOutdatedObserver = null;
      }
    };

    public Subscription(String location) {
      this.location = location;
    }

    public void queuePlaceIfNeeded() {
      if (placeOutdated) {
        queue.add(renderPlace());
      }
    }

    public Update renderPlace() {
      if (placeOutdatedObserver != null) {
        placeOutdatedObserver.remove();
        placeOutdatedObserver = null;
      }
      Update update = new Update();
      update.setName("subscription");
      update.setLocation(location);

      RenderContext renderContext = locatePlace(location);
      if (renderContext == null) {
        update.setRootFragment(PLACE_NOT_FOUND);
        return update;
      }
      PlaceTemplate placeTemplate = (PlaceTemplate) renderContext.getFlowContext().getCurrentPlaceTemplate();

      CaseAdministration caseAdministration = renderContext.getCaseInstance().getMetadata().getCaseAdministration();
      caseAdministration.startRecordingObservations();
      update.setRootFragment(placeTemplate.render(renderContext));

      Observations observations = caseAdministration.stopRecordingObservations();

      placeOutdated = false;
      placeOutdatedObserver = new ObservationsOutdatedObserver(observations, placeOutdatedValueChangeObserver);
      return update;
    }
  }

  private final TravelerProxy proxy;
  private final TravelerInfo travelerInfo;
  private final CaseManager caseManager;
  private List<Subscription> subscriptions = new ArrayList<Subscription>();
  private List<Update> queue = new ArrayList<Update>();

  private boolean presenceOutdated = true;
  private boolean placeOutdated = true;

  private ObservationsOutdatedObserver placeOutdatedObserver;
  private final ValueChangeObserver placeOutdatedValueChangeObserver = new ValueChangeObserver() {
    @Override
    public void valueChanged(ValueChangeEvent event) {
      placeOutdated = true;
      placeOutdatedObserver = null;
    }
  };

  private ObservationsOutdatedObserver presenceOutdatedObserver;
  private final ValueChangeObserver presenceOutdatedValueChangeObserver = new ValueChangeObserver() {
    @Override
    public void valueChanged(ValueChangeEvent event) {
      presenceOutdated = true;
      presenceOutdatedObserver = null;
    }
  };

  public Traveler() {
    throw new RuntimeException("Not implemented");
  }

  public Traveler(String uniqueId) {
    throw new RuntimeException("Not implemented");
  }

  public Traveler(TravelerProxy proxy, CaseManager caseManager) {
    this.caseManager = caseManager;
    this.proxy = proxy;
    this.travelerInfo = proxy.getTravelerInfo();
    setId(travelerInfo.getTravelerId());
    this.getCurrentPlaceRelationValue().addValueChangeObserver(placeOutdatedValueChangeObserver);
  }

  public void addSubscription(String location) {
    subscriptions.add(new Subscription(location));
  }

  public void removeSubscription(String location) {
    Iterator<Subscription> iterator = subscriptions.iterator();
    while (iterator.hasNext()) {
      Subscription subscription = iterator.next();
      if (subscription.location.equals(location)) {
        iterator.remove();
      }
    }
  }

  public void queuePlaceIfNeeded() {
    if (this.placeOutdated && getCurrentPlace() != null) {
      queue.add(renderPlace());
    }
    for (Subscription subscription : subscriptions) {
      subscription.queuePlaceIfNeeded();
    }
  }

  public Update renderPlace() {
    if (placeOutdatedObserver != null) {
      placeOutdatedObserver.remove();
      placeOutdatedObserver = null;
    }

    Update update = new Update();
    update.setName("place");
    update.setLocation(getCurrentPlace().getLocation().getUrl());

    RenderContext renderContext = locatePlace(getCurrentPlace().getLocation().getUrl());
    if (renderContext == null) {
      update.setRootFragment(PLACE_NOT_FOUND);
      return update;
    }
    PlaceTemplate placeTemplate = (PlaceTemplate) renderContext.getFlowContext().getCurrentPlaceTemplate();

    CaseAdministration caseAdministration = renderContext.getCaseInstance().getMetadata().getCaseAdministration();
    caseAdministration.startRecordingObservations();
    // Record observations on the presence during rendering as well (for bookmarks in data-explorer for example)
    getMetadata().getCaseAdministration().startRecordingObservations();
    LocationInfo locationInfo = placeTemplate.provideInfo(renderContext);
    update.setRootFragment(placeTemplate.render(renderContext));
    String title = (String) update.getRootFragment().get("title");
    if (title == null) {
      title = "?";
    }
    getCurrentPlace().setCurrentTitle(title);
    getCurrentPlace().setLocation(locationInfo);

    update.getRootFragment().put("themeNames", caseManager.getApplication().getThemeNames());
    Observations presenceObservations = getMetadata().getCaseAdministration().stopRecordingObservations();
    Observations observations = caseAdministration.stopRecordingObservations();
    for (ReadOnlyAttributeValue<? extends Instance, ? extends Object> observation : presenceObservations.getValuesObserved()) {
      observations.add(observation);
    }

    placeOutdated = false;
    placeOutdatedObserver = new ObservationsOutdatedObserver(observations, placeOutdatedValueChangeObserver);
    return update;
  }

  public void queuePresenceIfNeeded() {
    if (this.presenceOutdated) {
      String location = "Traveler(traveler:" + getMetadata().getUniqueId() + ")";
      queue.add(0, renderPresence(location, TravelerPlaceTemplate.INSTANCE)); // Presence is always the first message
    }
  }

  public Update renderPresence(String location, PlaceTemplate placeTemplate) {
    if (presenceOutdatedObserver != null) {
      presenceOutdatedObserver.remove();
      presenceOutdatedObserver = null;
    }

    FlowContext flowContext = new FlowContext(PresenceApplication.INSTANCE, caseManager.getPresence(), "presence", getTravelerInfo());
    flowContext.setCurrentPlaceTemplate(TravelerPlaceTemplate.INSTANCE);
    RenderContext renderContext = new RenderContext(flowContext, location);
    renderContext.pushSelectedInstance(this, "traveler");
    CaseAdministration caseAdministration = caseManager.getPresence().getMetadata().getCaseAdministration();
    caseAdministration.startRecordingObservations();
    Map<String, Object> result = placeTemplate.render(renderContext);
    Observations observations = caseAdministration.stopRecordingObservations();

    presenceOutdated = false;
    presenceOutdatedObserver = new ObservationsOutdatedObserver(observations, presenceOutdatedValueChangeObserver);

    Update update = new Update();
    update.setName("presence");
    update.setRootFragment(result);
    return update;
  }

  public void sendQueuedUpdates() {
    this.proxy.sendUpdates(queue);
    queue = new ArrayList<Update>();
  }

  private RenderContext locatePlace(String location) {
    try {
      Application application = this.caseManager.getApplication();
      return RenderContext.create(application, location, caseManager.getCase(), caseManager.getCaseId(), travelerInfo);
    } catch (NoSuchElementException e) {
      return null;
    } catch (InvalidFlowCoordinatesException e2) {
      return null;
    }
  }

  public TravelerProxy getProxy() {
    return proxy;
  }

  public TravelerInfo getTravelerInfo() {
    return travelerInfo;
  }

  public void placeUpdated() {
    placeOutdated = true;
  }

  public void sendException(Exception exception, boolean rendering) {
    this.queue = new ArrayList<Update>();
    this.placeOutdated = false;
    this.presenceOutdated = false;

    if (presenceOutdatedObserver != null) {
      presenceOutdatedObserver.remove();
      presenceOutdatedObserver = null;
    }

    if (placeOutdatedObserver != null) {
      placeOutdatedObserver.remove();
      placeOutdatedObserver = null;
    }
    this.proxy.sendUpdates(Collections.singletonList(new Update(exception, rendering)));
  }

  public void applicationUpdated() {
    placeOutdated = true;
    if (placeOutdatedObserver != null) {
      placeOutdatedObserver.remove();
      placeOutdatedObserver = null;
    }
  }
}
