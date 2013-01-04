/* Copyright 2013, Johan Gorter
 * This file is part of Instantlogic.
 * Instantlogic is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General
 * Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version. Instantlogic is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser 
 * General Public License for more details. You should have received a copy of the GNU Lesser General Public License
 * along with Instantlogic. If not, see <http://www.gnu.org/licenses/>.
 */

package org.instantlogic.fabric.util;

/**
 * Provides meta-information about the value of an AttributeValue
 */
public enum ValueLevel {

	/**
	 * The value is not relevant.
	 * The value is null per definition.
	 * This gives a hint to the user interface that this field should be hidden. 
	 */
	IRRELEVANT,
	/**
	 * The value is deduced by a (business) rule. 
	 * The value may or may not be null.
	 * Storing a different value will not have an effect. Therefore, the user interface should display this field as readonly. 
	 */
	RULE,
	/**
	 * The value is the same as the value stored at this attribute.
	 * The value is never null. (when a user clears the value, the default rule kicks in)
	 */
	STORED,
	/**
	 * The value is deduced by a default. 
	 * The value may or may not be null.
	 */
	DEFAULT,
	/**
	 * The value could not be determined.
	 * The value is null. 
	 * FirstDeduction will try the next deduction to deduce a value.
	 */
	INCONCLUSIVE,
	
}
