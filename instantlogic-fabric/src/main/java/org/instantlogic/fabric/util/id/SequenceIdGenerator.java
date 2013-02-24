package org.instantlogic.fabric.util.id;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *  This Id generator starts at 1 and increments every id it generates. It is thread-safe.
 */
public class SequenceIdGenerator implements IdGenerator {

	private static AtomicInteger next = new AtomicInteger();

	@Override
	public Id generate(String label) {
		long seq = next.incrementAndGet();
		return new Id(0l, seq);
	}
}
