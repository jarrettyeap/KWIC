package adt.output;

import java.util.ArrayList;

public class Output {
	
	/**
	 * To print out the String in the ArrayList
	 * @param arrayList
	 */
	public void print (ArrayList<String> arrayList) {
		for (int i=0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		System.out.println();
	}
	
}
