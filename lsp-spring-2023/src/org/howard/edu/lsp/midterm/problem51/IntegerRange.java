package org.howard.edu.lsp.midterm.problem51;

import java.util.stream.IntStream;

public class IntegerRange implements Range {
	private int lower;
   	private int upper;
	public boolean overlap;
   	
  	IntegerRange(int lower, int upper) {
  		this.setLower(lower);
 		this.setUpper(upper);
  	}
  	 
	public int getLower() {
		return lower;
	}

	public void setLower(int lower) {
		this.lower = lower;
	}

	public int getUpper() {
		return upper;
	}

	public void setUpper(int upper) {
		this.upper = upper;
	}
	
	@Override
	public boolean contains(int value) {
		// Assuming the range is all inclusive meaning it includes all values
		// Ex. If lower is 10 and upper is 20 then the range is 11
		// In above example 10 and 20 ARE apart of the range
		// The range would be 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
		return (value >= this.lower && value <= this.upper);
	}
			
	@Override
	public boolean overlaps(Range other) throws Exception {		
		if (other == null) {
			throw new Exception("EmptyRangeException");	
		}
		
		IntStream.range(this.lower, this.upper+1).forEach(value -> {
		    System.out.println(value);
		    if (other.contains(value)) {
		    	this.overlap = true;
		    }
		});
		
		return this.overlap;
	}

	@Override
	public int size() {
		// Assuming the range is all inclusive meaning it includes all values
		// Ex. If lower is 10 and upper is 20 then the range is 11
		// In above example 10 and 20 ARE apart of the range
		// The range would be 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20
		return this.upper-this.lower+1;
	}
}
