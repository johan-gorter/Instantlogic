package org.instantlogic.engine.presence.flow.traveler;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.engine.presence.PlaceEntityGenerator;
import org.instantlogic.engine.presence.PresenceEntityGenerator;
import org.instantlogic.engine.presence.TravelerEntityGenerator;
import org.instantlogic.engine.presence.UserEntityGenerator;

public class TravelerPlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final TravelerPlaceTemplateGenerator PLACE = new TravelerPlaceTemplateGenerator();
	
	private TravelerPlaceTemplateGenerator() {
		setName("Traveler");
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign applicationNameDeduction, caseNameDeduction, userHasValue, travelerUsername, 
			activeUsers, username, userTravelers, travelerId, travelerPlaceUrl, travelerPlaceTitle, visitors, username2, focus, currentPlace;
		FragmentTemplateDesign debugVisible;
		
		setContent(
			new FragmentTemplateDesign("Group")
				.setChildren("content", 
					new FragmentTemplateDesign("Presence")
						.setValue("applicationName", applicationNameDeduction = new DeductionSchemeDesign())
						.setValue("caseName", caseNameDeduction = new DeductionSchemeDesign())
						.setChildren("content", new ElementDesign[]{
							new IfElseDesign()
								.setCondition(userHasValue = new DeductionSchemeDesign()) // Logged in
								.addToIfChildren(
									new FragmentTemplateDesign("Me")
										.setValue("username", travelerUsername = new DeductionSchemeDesign())
								)
								.addToIfChildren(
									debugVisible = new FragmentTemplateDesign("DebugVisibleToggle")
								)
								.addToIfChildren(
									new FragmentTemplateDesign("Communicator")
										.setChildren("users", 
											new SelectionDesign()
												.setSelection(activeUsers = new DeductionSchemeDesign())
												.addToChildren(new FragmentTemplateDesign("User")
													.setValue("username", username = new DeductionSchemeDesign())
													.setChildren("travelers", 
														new SelectionDesign()
															.setSelection(userTravelers = new DeductionSchemeDesign())
															.addToChildren(new FragmentTemplateDesign("Traveler")
																.setValue("travelerId", travelerId = new DeductionSchemeDesign())
																.setValue("placeUrl", travelerPlaceUrl = new DeductionSchemeDesign())
																.setValue("placeTitle", travelerPlaceTitle = new DeductionSchemeDesign())
															)
													)
												)
										)
								)
								.addToElseChildren(new FragmentTemplateDesign("Login"))
						}),
						new SelectionDesign()
							.setSelection(currentPlace = new DeductionSchemeDesign())
							.addToChildren(
								new SelectionDesign()
									.setSelection(visitors = new DeductionSchemeDesign()) // Render avatars for everyone visiting this place
									.addToChildren(
										new FragmentTemplateDesign("Avatar")
											.setValue("username", username2 = new DeductionSchemeDesign())
											.setValue("focus", focus = new DeductionSchemeDesign())
									)
							)
				)
		);
		
		applicationNameDeduction.deduceAttribute(PresenceEntityGenerator.applicationName);
		caseNameDeduction.deduceAttribute(PresenceEntityGenerator.caseName);
		userHasValue.deduceHasValue(
			userHasValue.deduceRelation(TravelerEntityGenerator.user, 
				userHasValue.deduceSelectedInstance(TravelerEntityGenerator.ENTITY)));
		travelerUsername.deduceAttribute(UserEntityGenerator.username, 
			travelerUsername.deduceRelation(TravelerEntityGenerator.user, 
				travelerUsername.deduceSelectedInstance(TravelerEntityGenerator.ENTITY)));
		activeUsers.deduceRelation(PresenceEntityGenerator.activeUsers);
		username.deduceAttribute(UserEntityGenerator.username);
		userTravelers.deduceReverseRelation(TravelerEntityGenerator.user, 
			userTravelers.deduceSelectedInstance(UserEntityGenerator.ENTITY));
		travelerId.deduceAttribute(TravelerEntityGenerator.id);
		travelerPlaceUrl.deduceAttribute(PlaceEntityGenerator.url, 
			travelerPlaceUrl.deduceRelation(TravelerEntityGenerator.currentPlace));
		travelerPlaceTitle.deduceAttribute(PlaceEntityGenerator.title, 
			travelerPlaceTitle.deduceRelation(TravelerEntityGenerator.currentPlace));
		visitors.deduceReverseRelation(TravelerEntityGenerator.currentPlace, visitors.deduceSelectedInstance(PlaceEntityGenerator.ENTITY));
		username2.deduceAttribute(UserEntityGenerator.username, username2.deduceRelation(TravelerEntityGenerator.user));
		currentPlace.deduceRelation(TravelerEntityGenerator.currentPlace);
		focus.deduceAttribute(TravelerEntityGenerator.focus);
		
		debugVisible.setEntity(TravelerEntityGenerator.ENTITY).setAttribute(TravelerEntityGenerator.debugVisible);
	}
}
