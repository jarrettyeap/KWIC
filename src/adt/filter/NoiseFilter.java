package adt.filter;

import adt.memory.NoiseWordMemory;

import java.util.ArrayList;
import java.util.List;

public class NoiseFilter {
    private List<String> filterList = new ArrayList<String>();

    /**
     * To filter out String with noise (ignored) word as the first word of the sentence.
     *
     * @param inputList the list of string to filter and store
     */
    public void noiseWordFilter(List<String> inputList) {
        List<String> noiseWordList = NoiseWordMemory.getInstance().getNoiseList();

        for (int i = 0; i < noiseWordList.size(); i++) {
            String noiseWord = noiseWordList.get(i);
            for (int j = 0; j < inputList.size(); j++) {
                String inputString = inputList.get(j);
                String[] stringArray = inputString.split("\\s+");
                if (stringArray[0].equalsIgnoreCase(noiseWord)) {
                    inputList.remove(j);
                    j--;
                }
            }
        }
        filterList = inputList;
    }

    /**
     * Returns the filtered list stored in the object.
     *
     * @return the list stored in the current class object
     */
    public List<String> getFilterList() {
        return filterList;
    }
}
