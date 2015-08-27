package adt.duplicate;

import java.util.ArrayList;

public class CheckDuplicate {

	public void checkDuplicate(ArrayList<String> arrayList) {
		for (int i=0; i<arrayList.size()-1; i++) {
			for (int j=i+1; j<arrayList.size(); j++) {
				if (arrayList.get(i).equalsIgnoreCase(arrayList.get(j))) {
					arrayList.remove(j);
				}
			}
		}
		
	}
}
