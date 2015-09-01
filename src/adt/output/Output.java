package adt.output;

import java.util.ArrayList;

public class Output {

	private static String header = "--------------------------";
    /**
     * To print out the String in the ArrayList
     *
     * @param arrayList
     */
    public void print(ArrayList<String> arrayList) {

    	System.out.println(header);
    	System.out.println("KWIC Index");
    	System.out.println(header);
    	
    	for (int i = 0; i < arrayList.size(); i++) {
    		System.out.println(arrayList.get(i));
    	}
    	System.out.println(header);
    }

}
