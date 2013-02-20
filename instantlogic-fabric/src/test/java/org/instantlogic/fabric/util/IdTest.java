package org.instantlogic.fabric.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IdTest {

	@Test
	public void testOnes() {
		Id ones = Id.parse("zZZZZZZZZZZZZZZZ_ffffffff_ffff");
		assertEquals(0xffffffff, ones.getHiBits());
		assertEquals(0xffffffff, ones.getLoBits());
		assertEquals("zZZZZZZZZZZZZZZZ_ffffffff_ffff", ones.toString());
	}

	@Test
	public void testZeroes() {
		Id zeroes = Id.parse("__");
		assertEquals(0, zeroes.getHiBits());
		assertEquals(0, zeroes.getLoBits());
		assertEquals("__", zeroes.toString());
	}
}
