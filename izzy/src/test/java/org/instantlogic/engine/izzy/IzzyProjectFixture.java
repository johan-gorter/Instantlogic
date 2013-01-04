/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.engine.izzy;

import org.instantlogic.example.izzy.Comment;
import org.instantlogic.example.izzy.Issue;
import org.instantlogic.example.izzy.Project;
import org.instantlogic.example.izzy.User;

public class IzzyProjectFixture {
	
	public final Project project;
	public final User tester;
	public final User programmer;
	public final Issue issue1;
	public final Comment comment1;
	
	public IzzyProjectFixture() {
		tester = new User().setUsername("tester");
		programmer = new User().setUsername("programmer");
		issue1 = new Issue().setHeadline("issue1");
		comment1 = new Comment().setText("comment1");
		project = new Project()
			.addToUsers(tester)
			.addToUsers(programmer)
			.addToIssues(issue1);
		issue1.setReporter(tester).setAssignee(programmer);
		issue1.addToComments(comment1);
		comment1.setBy(programmer);
	}
	
}
