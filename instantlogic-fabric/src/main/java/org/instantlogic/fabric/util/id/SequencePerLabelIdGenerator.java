package org.instantlogic.fabric.util.id;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class SequencePerLabelIdGenerator implements IdGenerator {

	private class Entry {
		Id base;
		final AtomicInteger next = new AtomicInteger();
	}
	
	private final ConcurrentHashMap<String, Entry> entries = new ConcurrentHashMap<String, Entry>();
	
	@Override
	public Id generate(String label) {
		Entry entry = entries.get(label);
		if (entry==null) {
			entry = new Entry();
			entry.base = Id.newFixedId(label);
			Entry concurrentEntry = entries.putIfAbsent(label, entry);
			if (concurrentEntry!=null) entry = concurrentEntry;
		}
		return new Id(entry.base.getHiBits(), entry.base.getLoBits()+entry.next.incrementAndGet());
	}
}
