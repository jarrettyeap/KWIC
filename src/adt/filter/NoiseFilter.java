package adt.filter;

import java.util.ArrayList;

import adt.memory.NoiseWordMemory;

public class NoiseFilter {

	NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();

	private ArrayList<String> filterList = new ArrayList<String>();
	private ArrayList<String> noiseWordList = noiseWordArray.getArrayList();

	public ArrayList<String> noiseWordFilter(ArrayList<String> inputArray) {

		filterList = inputArray;
		
		String noiseWord;
		String inputString;

		for (int i=0; i<noiseWordList.size(); i++) {
			noiseWord = noiseWordList.get(i);

			for (int j=0; j<filterList.size(); j++) {
				inputString = filterList.get(j);
				String[] stringArray = inputString.split("\\s");

				if(stringArray[0].equals(noiseWord)) {
					filterList.remove(j);
					j--;
				}
			}
		}
		return filterList;
	}

	public ArrayList<String> getFilterList() {
		return filterList;
	}
	
}
