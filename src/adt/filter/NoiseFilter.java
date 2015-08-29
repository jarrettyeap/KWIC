package adt.filter;

import adt.memory.NoiseWordMemory;

import java.util.ArrayList;

public class NoiseFilter {

    NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();

    private ArrayList<String> filterList = new ArrayList<String>();
    private ArrayList<String> noiseWordList = noiseWordArray.getArrayList();


    /**
     * To filter out String with noise word as the 1st word of the sentence
     *
     * @param inputArray
     * @return
     */
    public ArrayList<String> noiseWordFilter(ArrayList<String> inputArray) {

        filterList = inputArray;

        String noiseWord;
        String inputString;

        for (int i = 0; i < noiseWordList.size(); i++) {
            noiseWord = noiseWordList.get(i);

            for (int j = 0; j < filterList.size(); j++) {
                inputString = filterList.get(j);
                String[] stringArray = inputString.split("\\s");

                if (stringArray[0].equals(noiseWord)) {
                    filterList.remove(j);
                    j--;
                }
            }
        }
        return filterList;
    }

    /**
     * To return the filtered ArrayList
     *
     * @return
     */
    public ArrayList<String> getFilterList() {
        return filterList;
    }

}
