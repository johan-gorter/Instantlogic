package org.instantlogic.fabric.util.id;

/**
 * Creates secure random Id's, using the same algorithm as a UUID/GUID level 4
 *
 */
public class RandomIdGenerator implements IdGenerator {

	@Override
	public Id generate(String label) {
		return Id.newRandomId();
	}
}
