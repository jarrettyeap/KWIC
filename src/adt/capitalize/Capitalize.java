package adt.capitalize;

import java.util.ArrayList;

import adt.memory.NoiseWordMemory;

public class Capitalize {

	NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();

	private ArrayList<String> noiseWordList = noiseWordArray.getArrayList();
	private ArrayList<String> capitalizeList = new ArrayList<String>();

	public void capitalize(ArrayList<String> inputArray) {

		ArrayList<String> arrayCapitalizing = new ArrayList<String>();

		for (int i = 0; i < inputArray.size(); i++) {
			String string = inputArray.get(i);
			String[] stringArray = string.split("\\s");
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < stringArray.length; j++) {
				stringArray[j] = stringArray[j].substring(0, 1).toUpperCase()
						+ stringArray[j].substring(1);

				for (int k = 0; k < noiseWordList.size(); k++) {
					if (stringArray[j].equalsIgnoreCase(noiseWordList.get(k))) {
						stringArray[j] = stringArray[j].toLowerCase();
					}
				}
				sb.append(stringArray[j]);
				sb.append(" ");
			}

			arrayCapitalizing.add(sb.toString().trim());
		}

		capitalizeList = arrayCapitalizing;
	}

	public ArrayList<String> getCapitalList() {
		return capitalizeList;
	}
}
