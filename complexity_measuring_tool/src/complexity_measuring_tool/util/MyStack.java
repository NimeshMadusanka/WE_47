package complexity_measuring_tool.util;

import java.util.ArrayList;
/*
 * @Author Peiris.M.R.P
 * IT16173064
 */
public class MyStack {
	
	private int topCount;
	private ArrayList<String> lineArray;
	
	public MyStack(){
		topCount = -1;
		lineArray = new ArrayList<String>();
	}
	
	public void push(String line) {
		topCount++;
		lineArray.add(line);
	}
	
	public String pop() {
		String topOne= lineArray.remove(topCount);
		topCount--;
		return topOne;
	}
	
	public int peek() {
		return topCount+1; 
	}
}
