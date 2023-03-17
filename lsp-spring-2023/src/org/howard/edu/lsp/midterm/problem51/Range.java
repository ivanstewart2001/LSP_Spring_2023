package org.howard.edu.lsp.midterm.problem51;

public interface Range {
	public boolean contains(int value);
	
	public boolean overlaps(Range other) throws Exception;
	
	public int size();
}
