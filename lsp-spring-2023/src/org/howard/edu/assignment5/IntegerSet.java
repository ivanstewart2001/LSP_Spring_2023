/**
 * 
 */
package org.howard.edu.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This class represents an integer set. An integer set is a collection of 
 * integers that contain no duplicates.
 * 
 * <br>
 * <br>
 * This class contains the following methods
 * <div>
 * <ul>
 * <li> clear() => void: Clears the internal representation of the set </li>
 * <li> length() => Integer: Returns the length of the set </li>
 * <li> equals(IntegerSet) => boolean: Returns true if the 2 sets are equal, false otherwise </li>
 * <li> contains() => boolean: Returns true if the set contains the value, otherwise false </li>
 * <li> largest() => Integer: Returns the largest item in the set; Throws a IntegerSetException if the set is empty </li>
 * <li> smallest() => Integer: Returns the smallest item in the set; Throws a IntegerSetException if the set is empty </li>
 * <li> add(Integer) => void: Adds an item to the set or does nothing it already there </li>
 * <li> remove(Integer) => void: Removes an item from the set or does nothing if not there </li>
 * <li> union(IntegerSet) => void: changes set to union of sets </li>
 * <li> intersect(IntegerSet) => void: changes set to intersection of sets </li>
 * <li> diff(IntegerSet) => void: changes set to difference between sets </li>
 * <li> isEmpty() => boolean: Returns true if the set is empty, false otherwise </li>
 * <li> toString() => String : Return String representation of your set </li>
 * </ul>
 * </div>
 * 
 * @author ivanstewart
 *
 */
public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();
	
	/**
	 * Public method for IntegerSet. No functionality.
	 * 
	 */
	public IntegerSet() {}
	
	/**
	 * Clears the internal representation of the set
	 * 
	 */
	public void clear() {
		this.set.clear();
	};
	
	/**
	 * Returns the length of the set
	 * 
	 * @return Integer - length of set
	 * 
	 */
	public Integer length() {
		return this.set.size();
	};
	
	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	 * 
	 * @param b - IntegerSet to compare
	 * @return boolean
	 * 
	 */
	public boolean equals(IntegerSet b) {
		if (this.length() != b.length()) {
			return false;
		}
		
		int count = 0;
		for (Integer integer : this.set) {
			if (b.contains(integer)) {
				count++;
			}
		}
		
		if (count == this.length()) {
			return true;
		} else {
			return false;
		}
	};
	
	/**
	 * Returns true if the set contains the value, otherwise false
	 * 
	 * @param value - integer to check if it is in set
	 * @return boolean
	 * 
	 */
	public boolean contains(Integer value) {
		if (this.set.contains(value)) {
			return true;
		} else {
			return false;
		}
	};
	
	/**
	 * Returns the largest item in the set;
	 * Throws a IntegerSetException if the set is empty
	 * 
	 * @return Integer - largest item in the set
	 * @throws Exception if set is empty
	 * 
	 */
	public Integer largest() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("IntegerSetException");
		}
		
		return Collections.max(this.set);
	};
	
	/**
	 * Returns the smallest item in the set;
	 * Throws a IntegerSetException if the set is empty
	 * 
	 * @return Integer - smallest item in the set
	 * @throws Exception if set is empty
	 * 
	 */
	public Integer smallest() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("IntegerSetException");
		}
		
		return Collections.min(this.set);
	};
	
	/**
	 * Adds an item to the set or does nothing it already there
	 * 
	 * @param item - integer to add to set
	 * 
	 */
	public void add(Integer item) {
		if (!this.contains(item) && item == (int)item) {
			set.add(item);
		}
	};
	
	/**
	 * Removes an item from the set or does nothing if not there 
	 * 
	 * @param item - integer to remove from set
	 * 
	 */
	public void remove(Integer item) {
		if (this.contains(item)) {
		      List<Integer> filtered = this.set.stream()
		                .filter(integer -> integer != item)
		                .collect(Collectors.toList());

		      this.set = filtered;
		}
	};
	
	/**
	 * Changes set to union of sets
	 * 
	 * @param intSetb - set to find union of
	 * 
	 */
	public void union(IntegerSet intSetb) {
		HashSet<Integer> unionSet = new HashSet<>();
		
		unionSet.addAll(this.set);
		unionSet.addAll(intSetb.set);
		
		Integer[] union = {};
	    union = unionSet.toArray(union);
	    
	    this.clear();
		for (Integer integer : union) {
			this.add(integer);
		}
	};

	/**
	 * Changes set to intersection of sets
	 * 
	 * @param intSetb - set to find intersection of
	 * 
	 */
	public void intersect(IntegerSet intSetb) {
		this.set.retainAll(intSetb.set);
		Object[] intersection = this.set.toArray();
		this.clear();

		for (Object integer : intersection) {
			this.add((int) integer);
		}
	};

	/**
	 * Changes set to difference between sets
	 * 
	 * @param intSetb - set to find difference between
	 * 
	 */
	public void diff(IntegerSet intSetb) {
		Set<Integer> set1 = new HashSet<Integer>(this.set);
		Set<Integer> set2 = new HashSet<Integer>(intSetb.set);
		set1.removeAll(set2);

		this.clear();
		
		for (Integer integer : set1) {
			this.add(integer);
		}
	};
	
	/**
	 * Returns true if the set is empty, false otherwise
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isEmpty() {
		if (this.set.isEmpty()) {
			return true;
		} else {
			return false;
		}
	};
	
	/**
	 * Return String representation of set
	 * 
	 * @return String
	 * 
	 */
	public String toString() {
		return this.set.toString();
	};
}
