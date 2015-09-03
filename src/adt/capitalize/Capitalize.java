package adt.capitalize;

import adt.memory.NoiseWordMemory;

import java.util.ArrayList;
import java.util.List;

public class Capitalize {

    NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();

    private List<String> noiseWordList = noiseWordArray.getNoiseWords();
    private List<String> capitalizeList = new ArrayList<String>();

    public void capitalize(List<String> inputArray) {

        List<String> arrayCapitalizing = new ArrayList<String>();

        for (int i = 0; i < inputArray.size(); i++) {
            String string = inputArray.get(i);
            String[] stringArray = string.split("\\s");
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < stringArray.length; j++) {
                stringArray[j] = stringArray[j].toUpperCase();

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

    public List<String> getCapitalList() {
        return capitalizeList;
    }
}
