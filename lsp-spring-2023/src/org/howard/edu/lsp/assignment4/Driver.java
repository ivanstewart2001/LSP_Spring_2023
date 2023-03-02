/**
 * 
 */
package org.howard.edu.lsp.assignment4;

/**
 * @author ivanstewart
 *
 */
public class Driver {
	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();

		set1.add(12);
		set1.add(13);
		set1.add(5);
		set1.add(16);
		set1.add(9);
		set1.add(19);
		
		System.out.println("Testing toString(), smallest(), and largest()");
		System.out.println("Value of Set1 is:" + " " + set1.toString());
		try {
			System.out.println("Smallest value in Set1 is:" + " " + set1.smallest());
		} catch (Exception e) {}
		try {
			System.out.println("Largest value in Set1 is:" + " " + set1.largest());
		} catch (Exception e) {}

		set1.clear();
		System.out.println("Value of Set1 AFTER clearing is:" + " " + set1.toString());
		try {
			System.out.println("Smallest value in Set1 is:" + " " + set1.smallest());
		} catch (Exception e) {
			System.out.println("Getting smallest value failed due to set1 being empty" + " " + e);
		}
		try {
			System.out.println("Largest value in Set1 is:" + " " + " " + " " + set1.largest());
		} catch (Exception e) {
			System.out.println("Getting largest value failed due to set1 being empty" + " " + e);
		}
		
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
		
		System.out.println("############################################################################################################################");
		System.out.println("Union Test");
		System.out.println("Union of Set1 and Set2");
		System.out.println("Value of Set1 is:" + " " + set1.toString());
		System.out.println("Value of Set2 is:" + " " + set2.toString());
		set1.union(set2);	// union of set1 and set2
		System.out.println("Result of union of Set1 and Set2");
		System.out.println(set1.toString());	// result of union of set1 and set2
		
		System.out.println("############################################################################################################################");
		set1.clear();
		set2.clear();
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		System.out.println("Intersection Test");
		System.out.println("Intersection of Set1 and Set2");
		System.out.println("Value of Set1 is:" + " " + set1.toString());
		System.out.println("Value of Set2 is:" + " " + set2.toString());
		set1.intersect(set2);	// union of set1 and set2
		System.out.println("Result of intersection of Set1 and Set2");
		System.out.println(set1.toString());	// result of union of set1 and set2
		
		System.out.println("############################################################################################################################");
		set1.clear();
		set2.clear();
		
		set1.add(1);
		set1.add(2);
		set1.add(3);
		
		set2.add(2);
		set2.add(3);
		set2.add(4);
		
		System.out.println("Difference Test");
		System.out.println("Difference of Set1 and Set2");
		System.out.println("Value of Set1 is:" + " " + set1.toString());
		System.out.println("Value of Set2 is:" + " " + set2.toString());
		set1.diff(set2);	// union of set1 and set2
		System.out.println("Result of difference of Set1 and Set2");
		System.out.println(set1.toString());	// result of union of set1 and set2
		
		System.out.println("############################################################################################################################");
		System.out.println("Testing Clearing");
		System.out.println("Value of Set1 BEFORE clear is:" + " " + set1.toString());
		set1.clear();
		System.out.println("Value of Set1 AFTER clear is:" + " " + set1.toString());
		System.out.println("Value of Set2 BEFORE clear is:" + " " + set2.toString());
		set2.clear();
		System.out.println("Value of Set2 AFTER clear is:" + " " + set2.toString());
		
		System.out.println("############################################################################################################################");
		System.out.println("Testing Adding");
		System.out.println("Value of Set1 BEFORE add is:" + " " + set1.toString());
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Value of Set1 AFTER adding 1, 2, and 3 is:" + " " + set1.toString());
		System.out.println("Value of Set1 BEFORE adding 3 for the SECOND TIME:" + " " + set1.toString());
		set1.add(3);
		System.out.println("Value of Set1 AFTER adding 3 for the SECOND TIME:" + " " + set1.toString());
				
		System.out.println("############################################################################################################################");
		System.out.println("Testing Removing");
		System.out.println("Value of Set1 BEFORE removing 1 is:" + " " + set1.toString());
		set1.remove(1);
		System.out.println("Value of Set1 AFTER removing 1 is:" + " " + set1.toString());
		System.out.println("Value of Set1 BEFORE removing 2 is:" + " " + set1.toString());
		set1.remove(2);
		System.out.println("Value of Set1 AFTER removing 2 is:" + " " + set1.toString());
		set1.remove(100);
		System.out.println("Value of Set1 AFTER removing a value that DOES NOT EXIST in Set1:" + " " + set1.toString());
		
		System.out.println("############################################################################################################################");
		System.out.println("Testing isEmpty()");
		System.out.println("Value of Set1 BEFORE clearing is:" + " " + set1.toString());
		System.out.println("Is Set1 empty?:" + " " + set1.isEmpty());
		set1.clear();
		System.out.println("Value of Set1 AFTER clearing is:" + " " + set1.toString());
		System.out.println("Is Set1 empty?:" + " " + set1.isEmpty());
		
		System.out.println("############################################################################################################################");
		System.out.println("Testing length");
		System.out.println("Value of cleared Set1 is:" + " " + set1.toString());
		System.out.println("Length of Set1:" + " " + set1.length());
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Value of Set1 after adding 1, 2, and 3 is:" + " " + set1.toString());
		System.out.println("Length of Set1:" + " " + set1.length());
		
		System.out.println("############################################################################################################################");
		System.out.println("Testing equals");
		set1.clear();
		set2.clear();
		set1.add(1);
		set1.add(2);
		set1.add(3);
		System.out.println("Value of Set1 after adding 1, 2, and 3 is:" + " " + set1.toString());
		set2.add(1);
		set2.add(2);
		set2.add(3);
		System.out.println("Value of Set2 after adding 1, 2, and 3 is:" + " " + set2.toString());
		System.out.println("Are Set1 and Set2 equal?" + " " + set1.equals(set2));
		set2.add(4);
		System.out.println("Value of Set2 after adding 4 is:" + " " + set2.toString());
		System.out.println("Are Set1 and Set2 equal?" + " " + set1.equals(set2));
		
		System.out.println("############################################################################################################################");
		System.out.println("Testing contains");
		System.out.println("Value of Set1 is:" + " " + set1.toString());
		System.out.println("Does Set1 contain 1:" + " " + set1.contains(1));
		System.out.println("Does Set1 contain 5:" + " " + set1.contains(5));
		set1.clear();
		System.out.println("Value of Set1 AFTER clearing is:" + " " + set1.toString());
		System.out.println("Does Set1 contain 1:" + " " + set1.contains(1));
	}

}
