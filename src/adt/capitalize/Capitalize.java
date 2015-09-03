package adt.capitalize;

import adt.memory.NoiseWordMemory;

import java.util.ArrayList;
import java.util.List;

public class Capitalize {
    private List<String> capitalizeList = new ArrayList<String>();

    /**
     * Transforms keyword (non-noise words) into uppercase and the rest to lowercase.
     *
     * @param tempList the list to transform and store
     */
    public void capitalize(List<String> list) {
        List<String> noiseWordList = NoiseWordMemory.getInstance().getNoiseList();
        List<String> arrayCapitalizing = new ArrayList<String>();
        List<String> tempList = new ArrayList<String>(list);

        for (int i = 0; i < tempList.size(); i++) {
            String string = tempList.get(i);
            String[] stringArray = string.split("\\s+");
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

    /**
     * Returns the capitalized list stored in the object.
     *
     * @return the list stored in the current class object
     */
    public List<String> getCapitalList() {
        return capitalizeList;
    }
}
