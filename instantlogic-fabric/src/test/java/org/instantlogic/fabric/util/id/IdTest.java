package org.instantlogic.fabric.util.id;

import static org.junit.Assert.assertEquals;

import org.instantlogic.fabric.util.id.Id;
import org.junit.Test;

public class IdTest {

	@Test
	public void testOnes() {
		System.out.println(new Id(0xffffffff, 0xffffffff).toString());
		Id ones = Id.parse("uUUUUUUUUUUUUUUU_ffffffff_ffff");
		assertEquals(0xffffffff, ones.getHiBits());
		assertEquals(0xffffffff, ones.getLoBits());
		assertEquals("uUUUUUUUUUUUUUUU_ffffffff_ffff", ones.toString());
	}

	@Test
	public void testZeroes() {
		Id zeroes = Id.parse("__");
		assertEquals(0, zeroes.getHiBits());
		assertEquals(0, zeroes.getLoBits());
		assertEquals("__", zeroes.toString());
	}
	
	private void testFixedId(String test) {
		Id id = Id.newFixedId(test);
		String toString = id.toString();
		System.out.println(toString);
		Id id2 = Id.parse(toString);
		assertEquals(id, id2);
	}
	
	@Test
	public void testFixedId() {
		testFixedId("IfElseDesign");
		testFixedId("ElementDesign");
		testFixedId("SharedElementDefinitionDesign");
		testFixedId("ApplicationContextSharedElementGenerator");
		testFixedId("SelectedInstanceDeductionDesignEntityGenerator");
		testFixedId("Lorem ipsum dolor sit amet, consectetur adipisicing elit");
	}
}
