package org.instantlogic.engine.presence.placetemplate;

import org.instantlogic.designer.DeductionSchemeDesign;
import org.instantlogic.designer.ElementDesign;
import org.instantlogic.designer.FragmentTemplateDesign;
import org.instantlogic.designer.IfElseDesign;
import org.instantlogic.designer.PlaceParameterDesign;
import org.instantlogic.designer.PlaceTemplateDesign;
import org.instantlogic.designer.SelectionDesign;
import org.instantlogic.designer.StringTemplateDesign;
import org.instantlogic.designer.TextTemplateDesign;
import org.instantlogic.engine.presence.PlaceEntityGenerator;
import org.instantlogic.engine.presence.PresenceApplicationGenerator;
import org.instantlogic.engine.presence.PresenceEntityGenerator;
import org.instantlogic.engine.presence.TravelerEntityGenerator;
import org.instantlogic.engine.presence.UserEntityGenerator;

public class TravelerPlaceTemplateGenerator extends PlaceTemplateDesign {

	public static final TravelerPlaceTemplateGenerator PLACE = new TravelerPlaceTemplateGenerator();
	
	private TravelerPlaceTemplateGenerator() {
		setName("Traveler");
		setApplication(PresenceApplicationGenerator.APPLICATION);
	}
	
	@Override
	public void init() {
		DeductionSchemeDesign applicationNameDeduction, caseNameDeduction, userHasValue, user, userUsername, userAvatarUrl, userName, 
			activeUsers, username, avatarUrl, name, userTravelers, travelerId, travelerPlace, travelerPlaceTitle, visitors, username2, name2, avatarUrl2, 
			focus, isMe, currentPlace, showingBookmarks, selectBookmarks;
		FragmentTemplateDesign debugVisible, bookmarksToggle, bookmarksPopup, bookmarkLinks;
		
		PlaceParameterDesign travelerParameter = new PlaceParameterDesign();
		travelerParameter.setName("traveler");
		addToParameters(travelerParameter);
		travelerParameter.setEntity(TravelerEntityGenerator.ENTITY);
		
		setContent(
			new FragmentTemplateDesign()
			    .setType(PresenceApplicationGenerator.GROUP)
				.setChildren("content", 
					new FragmentTemplateDesign("Presence")
						.setValue("applicationName", applicationNameDeduction = new DeductionSchemeDesign())
						.setValue("caseName", caseNameDeduction = new DeductionSchemeDesign())
						.setChildren("content", new ElementDesign[]{
							new IfElseDesign()
								.setCondition(userHasValue = new DeductionSchemeDesign()) // Logged in
								.setIfChild(
									new FragmentTemplateDesign()
										.setType(PresenceApplicationGenerator.GROUP)
										.setChildren("content",
											new SelectionDesign()
												.setSelection(user = new DeductionSchemeDesign())
												.setChild(
													new FragmentTemplateDesign("Me")
														.setValue("username", userUsername = new DeductionSchemeDesign())
														.setValue("avatarUrl", userAvatarUrl = new DeductionSchemeDesign())
														.setValue("name", userName = new DeductionSchemeDesign())
												),
											bookmarksToggle = new FragmentTemplateDesign("ToggleBookmarks"),
											debugVisible = new FragmentTemplateDesign("DebugVisibleToggle"),
											new FragmentTemplateDesign("Communicator")
												.setChildren("users", 
													new SelectionDesign()
														.setSelection(activeUsers = new DeductionSchemeDesign())
														.setChild(new FragmentTemplateDesign("User")
															.setValue("username", username = new DeductionSchemeDesign())
															.setValue("avatarUrl", avatarUrl = new DeductionSchemeDesign())
															.setValue("name", name = new DeductionSchemeDesign())
															.setChildren("travelers", 
																new SelectionDesign()
																	.setSelection(userTravelers = new DeductionSchemeDesign())
																	.setChild(new FragmentTemplateDesign("Traveler")
																		.setValue("travelerId", travelerId = new DeductionSchemeDesign())
																		.setValue("place", travelerPlace = new DeductionSchemeDesign())
																		.setValue("placeTitle", travelerPlaceTitle = new DeductionSchemeDesign())
																	)
															)
														)
												),
											new IfElseDesign()
												.setCondition(showingBookmarks = new DeductionSchemeDesign())
												.setIfChild(bookmarksPopup = new FragmentTemplateDesign("BookmarksPopup")
												)
										)
								)
								.setElseChild(new FragmentTemplateDesign("Login"))
						}),
						new SelectionDesign()
							.setSelection(currentPlace = new DeductionSchemeDesign())
							.setChild(
								new SelectionDesign()
									.setSelection(visitors = new DeductionSchemeDesign()) // Render avatars for everyone visiting this place
									.setChild(
										new FragmentTemplateDesign("Avatar")
											.setValue("username", username2 = new DeductionSchemeDesign())
											.setValue("name", name2 = new DeductionSchemeDesign())
											.setValue("avatarUrl", avatarUrl2 = new DeductionSchemeDesign())
											.setValue("focus", focus = new DeductionSchemeDesign())
											.setValue("isMe", isMe = new DeductionSchemeDesign())
									)
							)
				)
		);
		
		applicationNameDeduction.deduceAttribute(PresenceEntityGenerator.applicationName);
		caseNameDeduction.deduceAttribute(PresenceEntityGenerator.caseName);
		userHasValue.deduceHasValue(
			userHasValue.deduceRelation(TravelerEntityGenerator.user, 
				userHasValue.deduceSelectedInstance(TravelerEntityGenerator.ENTITY)));

		user.deduceRelation(TravelerEntityGenerator.user);

		userUsername.deduceAttribute(UserEntityGenerator.username);
		userAvatarUrl.deduceAttribute(UserEntityGenerator.avatarUrl);
		userName.deduceAttribute(UserEntityGenerator.name);

		activeUsers.deduceRelation(PresenceEntityGenerator.activeUsers);

		username.deduceAttribute(UserEntityGenerator.username);
		avatarUrl.deduceAttribute(UserEntityGenerator.avatarUrl);
		name.deduceAttribute(UserEntityGenerator.name);
		
		userTravelers.deduceReverseRelation(TravelerEntityGenerator.user, 
			userTravelers.deduceSelectedInstance(UserEntityGenerator.ENTITY));
		travelerId.deduceAttribute(TravelerEntityGenerator.id);
		travelerPlace.deduceAttribute(PlaceEntityGenerator.location, 
			travelerPlace.deduceRelation(TravelerEntityGenerator.currentPlace));
		travelerPlaceTitle.deduceAttribute(PlaceEntityGenerator.currentTitle, 
			travelerPlaceTitle.deduceRelation(TravelerEntityGenerator.currentPlace));
		visitors.deduceReverseRelation(TravelerEntityGenerator.currentPlace, visitors.deduceSelectedInstance(PlaceEntityGenerator.ENTITY));

		username2.deduceAttribute(UserEntityGenerator.username, username2.deduceRelation(TravelerEntityGenerator.user));
		name2.deduceAttribute(UserEntityGenerator.name, name2.deduceRelation(TravelerEntityGenerator.user));
		avatarUrl2.deduceAttribute(UserEntityGenerator.avatarUrl, avatarUrl2.deduceRelation(TravelerEntityGenerator.user));
		
		currentPlace.deduceRelation(TravelerEntityGenerator.currentPlace);
		focus.deduceAttribute(TravelerEntityGenerator.focus);
		isMe.deduceCustom(PresenceApplicationGenerator.IsMeDeduction);

		debugVisible.setEntity(TravelerEntityGenerator.ENTITY).setAttribute(TravelerEntityGenerator.debugVisible);
		
		showingBookmarks.deduceAttribute(TravelerEntityGenerator.showingBookmarks);
		
		bookmarksToggle.setEntity(TravelerEntityGenerator.ENTITY).setAttribute(TravelerEntityGenerator.showingBookmarks);
		TextTemplateDesign addBookmarkText = new TextTemplateDesign();
		bookmarksPopup.setText("currentPlaceTitle", addBookmarkText);
		DeductionSchemeDesign currentTitle = new DeductionSchemeDesign();
		addBookmarkText.addToUntranslated(new StringTemplateDesign().setDeduction(currentTitle));
		currentTitle.deduceAttribute(PlaceEntityGenerator.currentTitle, currentTitle.deduceRelation(TravelerEntityGenerator.currentPlace));
		
		bookmarksPopup.setValue("bookmarksData", selectBookmarks = new DeductionSchemeDesign());
		selectBookmarks.deduceAttribute(UserEntityGenerator.bookmarks, selectBookmarks.deduceRelation(TravelerEntityGenerator.user));
	}
}
