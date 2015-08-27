package adt.sort;

import java.util.ArrayList;
import java.util.Collections;

public class AlphabetSort {

	ArrayList<String> sortedList = new ArrayList<String>();
	
	public ArrayList<String> alphabetize (ArrayList<String> inputList) {
		sortedList = inputList;
		Collections.sort(sortedList);
		
		return sortedList;
	}
	
	public ArrayList<String> getSortedList() {
		return sortedList;
	}
}

