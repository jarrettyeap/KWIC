package adt.output;

import java.util.ArrayList;

public class Output {
	
	public void print (ArrayList<String> arrayList) {
		for (int i=0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		System.out.println();
	}
	
}
