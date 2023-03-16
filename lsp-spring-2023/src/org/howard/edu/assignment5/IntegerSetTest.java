package org.howard.edu.assignment5;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class IntegerSetTest {

	@Test
	public void testClear() {
		IntegerSet set1 = new IntegerSet();
		
		assertEquals("Test empty set", (Object) set1.length(), (Object) 0);
		
		set1.clear();
		assertEquals("Test clearing empty set", (Object) set1.length(), (Object) 0);
		
		set1.add(12);
		set1.add(13);
		set1.add(5);
		set1.add(16);
		set1.add(9);
		set1.add(19);
		set1.clear();
		assertEquals("Test clearing non empty set", (Object) set1.length(), (Object) 0);
	}

	@Test
	public void testLength() {
		IntegerSet set1 = new IntegerSet();
		
		assertEquals("Test length of empty set", (Object) set1.length(), (Object) 0);
		
		set1.add(12);
		set1.add(13);
		set1.add(5);
		set1.add(16);
		set1.add(9);
		set1.add(19);
		assertEquals("Test length of non empty set", (Object) set1.length(), (Object) 6);
	}

	@Test
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.clear();
		set2.clear();
		assertTrue("Test if empty sets are equal", set1.equals(set2));
		assertTrue("Test if empty sets are equal", set2.equals(set1));
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set2.add(1);
		set2.add(2);
		set2.add(3);
		assertTrue("Test if non empty sets with same elements are equal", set1.equals(set2));
		assertTrue("Test if non empty sets with same elements are equal", set2.equals(set1));
		
		set2.clear();
		assertFalse("Test if different sets are equal", set1.equals(set2));
		assertFalse("Test if different sets are equal", set2.equals(set1));
	}

	@Test
	public void testContains() {
		IntegerSet set1 = new IntegerSet();
		
		assertFalse("Test if element in empty set", set1.contains(1));
		
		set1.add(1);
		assertTrue("Test if element in set that contains it", set1.contains(1));
		
		assertFalse("Test if element in set that does not contains it", set1.contains(10));
		
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		assertTrue("Test if element in set with multiple elements that contains it", set1.contains(3));
		
		set1.add(2);
		set1.add(3);
		set1.add(4);
		set1.add(5);
		assertFalse("Test if element in set with multiple elements that does not contains it", set1.contains(30));
	}

	@Rule
	public final ExpectedException exception = ExpectedException.none();
	  
	@Test
	public void testLargest() throws Exception {
		IntegerSet set1 = new IntegerSet();

		exception.expectMessage("IntegerSetException");
		set1.largest();
		
		set1.add(1);
		set1.add(3);
		set1.add(2);
		assertEquals("Test getting largest element in non empty set with length greater than 1", (Object) set1.largest(), (Object) 3);
		
		set1.clear();
		set1.add(1);
		assertEquals("Test getting largest element in non empty set with length equal to 1", (Object) set1.largest(), (Object) 1);
	}

	@Test
	public void testSmallest() throws Exception {
		IntegerSet set1 = new IntegerSet();

		exception.expectMessage("IntegerSetException");
		set1.smallest();
		
		set1.add(1);
		set1.add(3);
		set1.add(2);
		assertEquals("Test getting smallest element in non empty set with length greater than 1", (Object) set1.smallest(), (Object) 1);
		
		set1.clear();
		set1.add(1);
		assertEquals("Test getting smallest element in non empty set with length equal to 1", (Object) set1.smallest(), (Object) 1);
	}

	@Test
	public void testAdd() {
		IntegerSet set1 = new IntegerSet();
		
		set1.add(1);
		set1.add(1);
		assertEquals("Test adding duplicate elements to set", (Object) set1.toString(), (Object) "[1]");
		assertEquals("Test adding duplicate elements to set", (Object) set1.length(), (Object) 1);
		
		set1.add(2);
		set1.add(3);
		assertEquals("Test adding elements to set", (Object) set1.toString(), (Object) "[1, 2, 3]");
		assertEquals("Test adding elements to set", (Object) set1.length(), (Object) 3);
	}

	@Test
	public void testRemove() {
		IntegerSet set1 = new IntegerSet();
		
		set1.remove(1);
		assertEquals("Test removing element from empty set", (Object) set1.toString(), (Object) "[]");
		assertEquals("Test removing element from empty set", (Object) set1.length(), (Object) 0);
		
		set1.add(1);
		set1.remove(3);
		assertEquals("Test removing element that does not exist in non empty set with 1 element", (Object) set1.toString(), (Object) "[1]");
		assertEquals("Test removing element that does not exist in non empty set with 1 element", (Object) set1.length(), (Object) 1);
		
		set1.remove(1);
		assertEquals("Test removing element that does exist in non empty set", (Object) set1.toString(), (Object) "[]");
		assertEquals("Test removing element that does exist in non empty set", (Object) set1.length(), (Object) 0);
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.remove(20);
		assertEquals("Test removing element that does not exist in non empty set with more than 1 element", (Object) set1.toString(), (Object) "[1, 2, 3]");
		assertEquals("Test removing element that does not exist in non empty set with more than 1 element", (Object) set1.length(), (Object) 3);
		
		set1.remove(2);
		assertEquals("Test removing element that does exist in non empty set with more than 1 element", (Object) set1.toString(), (Object) "[1, 3]");
		assertEquals("Test removing element that does exist in non empty set with more than 1 element", (Object) set1.length(), (Object) 2);
	}

	@Test
	public void testUnion() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.union(set2);
		assertEquals("Test union of 2 empty sets", (Object) set1.toString(), (Object) "[]");
		assertEquals("Test union of 2 empty sets", (Object) set1.length(), (Object) 0);
		
		set1.add(12);
		set1.add(13);
		set1.add(5);
		set1.add(16);
		set1.add(9);
		set1.add(19);
		
		set2.add(16);
		set2.add(2);
		set2.add(60);
		set2.add(9);
		set2.add(8);
		set2.add(5);
		
		set1.union(set2);
		assertEquals("Test union of 2 non empty sets", (Object) set1.toString(), (Object) "[16, 2, 19, 5, 8, 9, 12, 60, 13]");
		assertEquals("Test union of 2 non empty sets", (Object) set1.length(), (Object) 9);
		
	}

	@Test
	public void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.intersect(set2);
		assertEquals("Test intersect of 2 empty sets", (Object) set1.toString(), (Object) "[]");
		assertEquals("Test intersect of 2 empty sets", (Object) set1.length(), (Object) 0);
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		set1.intersect(set2);
		assertEquals("Test intersect of 2 empty sets", (Object) set1.toString(), (Object) "[2, 3]");
		assertEquals("Test intersect of 2 empty sets", (Object) set1.length(), (Object) 2);
	}

	@Test
	public void testDiff() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		set1.diff(set2);
		assertEquals("Test difference of 2 empty sets", (Object) set1.toString(), (Object) "[]");
		assertEquals("Test difference of 2 empty sets", (Object) set1.length(), (Object) 0);
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		set1.diff(set2);
		assertEquals("Test difference of 2 empty sets", (Object) set1.toString(), (Object) "[1]");
		assertEquals("Test difference of 2 empty sets", (Object) set1.length(), (Object) 1);
	}

	@Test
	public void testIsEmpty() {
		IntegerSet set1 = new IntegerSet();
		
		assertTrue("Test if empty set is empty", set1.isEmpty());
		
		set1.add(1);
		assertFalse("Test if non empty set is empty", set1.isEmpty());
		
		set1.add(2);
		set1.add(3);
		assertFalse("Test if non empty set is empty", set1.isEmpty());
		
		set1.clear();
		assertTrue("Test if empty set is empty", set1.isEmpty());
	}

	@Test
	public void testToString() {
		IntegerSet set1 = new IntegerSet();
		
		assertEquals("Test string version of empty set", (Object) set1.toString(), (Object) "[]");
		
		set1.add(1);
		assertEquals("Test string version of non empty set", (Object) set1.toString(), (Object) "[1]");
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		assertEquals("Test string version of non empty set", (Object) set1.toString(), (Object) "[1, 2, 3]");
		
		set1.remove(2);
		assertEquals("Test string version of non empty set", (Object) set1.toString(), (Object) "[1, 3]");
	}
}
