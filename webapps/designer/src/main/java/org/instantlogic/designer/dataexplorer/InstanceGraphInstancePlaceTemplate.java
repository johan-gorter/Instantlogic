package org.instantlogic.designer.dataexplorer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.instantlogic.fabric.Instance;
import org.instantlogic.fabric.model.Attribute;
import org.instantlogic.fabric.model.Entity;
import org.instantlogic.fabric.model.Relation;
import org.instantlogic.interaction.flow.PlaceTemplate;
import org.instantlogic.interaction.page.FragmentTemplate;
import org.instantlogic.interaction.util.RenderContext;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class InstanceGraphInstancePlaceTemplate extends PlaceTemplate {

	public static final String NAME = "_InstanceGraph-instance";
	
	private DataExplorerAdministration administration;
	private Entity<?>[] parameters;
	
	private FragmentTemplate rootFragment = new FragmentTemplate("instanceGraphRoot", "Instance") {
	  @Override
	  protected Map<String, Object> doRender(RenderContext context, String fragmentId) {
	    Instance instance = context.getSelectedInstance(null);
	    Map<String, Object> result = new LinkedHashMap<String, Object>();
	    if (instance == null) {
	      return result;
	    }
	    result.put("type", getFragmentTypeName());
	    result.put("id", getInstanceId(instance));
	    result.put("entity", instance.getMetadata().getEntity().getName());
	    result.put("title", instance.renderTitle(context));
	    result.put("reverseRelations", getReverseRelationValues(instance)); //{id: "assignedIssues", reverse: "assignee", name: "assigned issues", value: ["issue1"]}
	    result.put("relations", getRelationValues(instance));
	    result.put("attributes", getAttributeValues(instance));
	    return result;
	  }

    private Object getReverseRelationValues(Instance instance) {
      List<Map<String, Object>> result = new ArrayList<>();
      for (Relation relation : instance.getMetadata().getEntity().getReverseRelations()) {
        if (relation.getReverseRelation().isOwner() && relation.get(instance).getValueAndLevel().getValue()!=null) {
          Map<String, Object> data = toData(relation, instance);
          data.put("multivalue", false);
          data.put("value", getRelationValue(relation, instance));
          data.put("reverse", relation.getReverseRelation().getUniqueId());
          data.put("ownedBy", true);
          result.add(data);
        }
      }
      for (Relation relation : instance.getMetadata().getEntity().getReverseRelations()) {
        if (!relation.getReverseRelation().isOwner()) {
          Map<String, Object> data = toData(relation, instance);
          data.put("multivalue", relation.isMultivalue());
          data.put("value", getRelationValue(relation, instance));
          data.put("reverse", relation.getReverseRelation().getUniqueId());
          result.add(data);
        }
      }
      return result;
    }

    private Object getRelationValues(Instance instance) {
      List<Map<String, Object>> result = new ArrayList<>();
      for (Relation relation : instance.getMetadata().getEntity().getRelations()) {
        if (relation.isOwner()) {
          Map<String, Object> data = toData(relation, instance);
          data.put("multivalue", relation.isMultivalue());
          data.put("value", getRelationValue(relation, instance));
          data.put("owner", true);
          result.add(data);
        }
      }
      for (Relation relation : instance.getMetadata().getEntity().getRelations()) {
        if (!relation.isOwner()) {
          Map<String, Object> data = toData(relation, instance);
          data.put("multivalue", relation.isMultivalue());
          data.put("value", getRelationValue(relation, instance));
          result.add(data);
        }
      }
      return result;
    }

    private Object getAttributeValues(Instance instance) {
      List<Map<String, Object>> result = new ArrayList<>();
      for (Attribute attribute : instance.getMetadata().getEntity().getAttributes()) {
        Map<String, Object> data = toData(attribute, instance);
        data.put("value", getValue(attribute, instance));
        result.add(data);
      }
      return result;
    }

    private Object getRelationValue(Relation relation, Instance instance) {
      if (relation.isMultivalue()) {
        List<String> results = new ArrayList<String>();
        for (Instance toInstance : (Iterable<Instance>)relation.get(instance).getValue()) {
          results.add(getInstanceId(toInstance));
        }
        return results;
      } else {
        Instance toInstance = (Instance) relation.get(instance).getValue();
        if (toInstance!=null) {
          Map<String, Object> result = new HashMap<>();
          result.put("id", getInstanceId(toInstance));
          result.put("title", toInstance.renderTitle());
          return result;
        }
        return null;
      }
    }

    private Object getValue(Attribute attribute, Instance instance) {
      if (attribute.isMultivalue()) {
        List<String> results = new ArrayList<String>();
        for (Object value : (Iterable<Instance>)attribute.get(instance).getValue()) {
          results.add(value.toString());
        }
        return results;
      } else {
        Object value = attribute.get(instance).getValue();
        if (value!=null) {
          return value.toString();
        }
        return null;
      }
    }

    private Map<String, Object> toData(Attribute attribute, Instance instance) {
      Map<String, Object> result = new HashMap<>();
      result.put("id", attribute.getUniqueId());
      result.put("name", attribute.getName());
      return result;
    }
	};
	
	public InstanceGraphInstancePlaceTemplate(DataExplorerAdministration administration) {
		this.parameters = new Entity<?>[]{null};
		this.administration = administration;
	}

	@Override
	public FragmentTemplate getRootContainer() {
		return rootFragment;
	}

	@Override
	public Entity<?>[] getParameters() {
		return parameters;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public String getId() {
		return getName();
	}
}
