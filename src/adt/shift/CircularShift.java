package adt.shift;

import java.util.ArrayList;

public class CircularShift {

	private ArrayList<String> shiftedList = new ArrayList<String>();
	
	/**
	public void circularizer(ArrayList<String> arrayList) {
		for (String sentence : arrayList) {
            String[] tokens = sentence.split("\\s");

            for (int start = 0; start < tokens.length; start++) {
                StringBuilder sb = new StringBuilder();
                for (int i = start; i < start + tokens.length; i++) {
                    sb.append(tokens[i % tokens.length]);
                    sb.append(" ");
                }
                shiftedList.add(sb.toString());
            }
        }
	}
	**/
	
	public void circularizer(ArrayList<String> inputArray) {
		for (int i=0; i<inputArray.size(); i++) {
			String string = inputArray.get(i);
			String [] stringArray = string.split("\\s");
			
			for (int firstWord = 0; firstWord<stringArray.length; firstWord++) {
				StringBuilder sb = new StringBuilder();
                for (int j = firstWord; j<firstWord + stringArray.length; j++) {
                    sb.append(stringArray[j % stringArray.length]);
                    sb.append(" ");
                }
                shiftedList.add(sb.toString());
			}
			
		}
	}
	
	public ArrayList<String> getArrayList() {
		return shiftedList;
	}

}