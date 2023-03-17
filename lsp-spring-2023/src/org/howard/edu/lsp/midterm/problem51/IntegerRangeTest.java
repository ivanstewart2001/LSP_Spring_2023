package org.howard.edu.lsp.midterm.problem51;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

class IntegerRangeTest {

	@Test
	void testConstructor() {
		IntegerRange range1 = new IntegerRange(10, 20);
		
		assertEquals("Test initializing IntegerRange", (Object) range1.getLower(), (Object) 10);
		assertEquals("Test initializing IntegerRange", (Object) range1.getUpper(), (Object) 20);
	}
	
	@Test
	void testContains() {
		IntegerRange range1 = new IntegerRange(10, 20);
		
		assertFalse("Test if range contains value not in range", range1.contains(100));
		assertFalse("Test if range contains value not in range", range1.contains(9));
		assertFalse("Test if range contains value not in range", range1.contains(21));
		
		assertTrue("Test if range contains value in range", range1.contains(10));
		assertTrue("Test if range contains value in range", range1.contains(11));
		assertTrue("Test if range contains value in range", range1.contains(12));
		assertTrue("Test if range contains value in range", range1.contains(13));
		assertTrue("Test if range contains value in range", range1.contains(14));
		assertTrue("Test if range contains value in range", range1.contains(15));
		assertTrue("Test if range contains value in range", range1.contains(16));
		assertTrue("Test if range contains value in range", range1.contains(17));
		assertTrue("Test if range contains value in range", range1.contains(18));
		assertTrue("Test if range contains value in range", range1.contains(19));
		assertTrue("Test if range contains value in range", range1.contains(20));
	}
	
	@Test
	void testOverlaps() throws Exception {
		IntegerRange range1 = new IntegerRange(10, 20);
		IntegerRange range2 = new IntegerRange(100, 200);
		IntegerRange range3 = new IntegerRange(15, 17);
		
		try {
			range1.overlaps(null);
		} catch (Exception e) {
			assertEquals("Test overlapping range with null", (Object) e.getMessage(), (Object) "EmptyRangeException");
		}
		
		assertFalse("Test if ranges do not overlap", range1.overlaps(range2));
		assertTrue("Test if ranges do overlap", range1.overlaps(range3));
	}
	
	@Test
	void testSize() {
		IntegerRange range1 = new IntegerRange(10, 20);
		assertEquals("Test range size", (Object) range1.size(), (Object) 11);
		
		IntegerRange range2 = new IntegerRange(1, 2);
		assertEquals("Test range size", (Object) range2.size(), (Object) 2);
		
		IntegerRange range3 = new IntegerRange(100, 200);
		assertEquals("Test range size", (Object) range3.size(), (Object) 101);
		
		IntegerRange range4 = new IntegerRange(1000, 2000);
		assertEquals("Test range size", (Object) range4.size(), (Object) 1001);
		
		IntegerRange range5 = new IntegerRange(0, 1);
		assertEquals("Test range size", (Object) range5.size(), (Object) 2);
	}

}
