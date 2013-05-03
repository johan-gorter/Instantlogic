/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

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
		DeductionSchemeDesign applicationNameDeduction, caseNameDeduction, userHasValue, user, userUsername, userAvatarUrl, userName, 
			activeUsers, username, avatarUrl, name, userTravelers, travelerId, travelerPlaceUrl, travelerPlaceTitle, visitors, username2, name2, avatarUrl2, focus, currentPlace;
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
								.setIfChild(
									new FragmentTemplateDesign("Block")
										.setChildren("content",
											new SelectionDesign()
												.setSelection(user = new DeductionSchemeDesign())
												.setChild(
													new FragmentTemplateDesign("Me")
														.setValue("username", userUsername = new DeductionSchemeDesign())
														.setValue("avatarUrl", userAvatarUrl = new DeductionSchemeDesign())
														.setValue("name", userName = new DeductionSchemeDesign())
												),
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
																		.setValue("placeUrl", travelerPlaceUrl = new DeductionSchemeDesign())
																		.setValue("placeTitle", travelerPlaceTitle = new DeductionSchemeDesign())
																	)
															)
														)
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
		travelerPlaceUrl.deduceAttribute(PlaceEntityGenerator.url, 
			travelerPlaceUrl.deduceRelation(TravelerEntityGenerator.currentPlace));
		travelerPlaceTitle.deduceAttribute(PlaceEntityGenerator.title, 
			travelerPlaceTitle.deduceRelation(TravelerEntityGenerator.currentPlace));
		visitors.deduceReverseRelation(TravelerEntityGenerator.currentPlace, visitors.deduceSelectedInstance(PlaceEntityGenerator.ENTITY));

		username2.deduceAttribute(UserEntityGenerator.username, username2.deduceRelation(TravelerEntityGenerator.user));
		name2.deduceAttribute(UserEntityGenerator.name, name2.deduceRelation(TravelerEntityGenerator.user));
		avatarUrl2.deduceAttribute(UserEntityGenerator.avatarUrl, avatarUrl2.deduceRelation(TravelerEntityGenerator.user));
		
		currentPlace.deduceRelation(TravelerEntityGenerator.currentPlace);
		focus.deduceAttribute(TravelerEntityGenerator.focus);
		
		debugVisible.setEntity(TravelerEntityGenerator.ENTITY).setAttribute(TravelerEntityGenerator.debugVisible);
	}
}
