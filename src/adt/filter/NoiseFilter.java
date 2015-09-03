package adt.filter;

import adt.memory.NoiseWordMemory;

import java.util.ArrayList;
import java.util.List;

public class NoiseFilter {

    NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();

    private List<String> filterList = new ArrayList<String>();
    private List<String> noiseWordList = noiseWordArray.getNoiseWords();


    /**
     * To filter out String with noise word as the 1st word of the sentence
     *
     * @param list
     * @return
     */
    public void noiseWordFilter(List<String> list) {

        String noiseWord;
        String inputString;

        for (int i = 0; i < noiseWordList.size(); i++) {
            noiseWord = noiseWordList.get(i);

            for (int j = 0; j < list.size(); j++) {
                inputString = list.get(j);
                String[] stringArray = inputString.split("\\s");

                if (stringArray[0].equalsIgnoreCase(noiseWord)) {
                    list.remove(j);
                    j--;
                }
            }
        }

        filterList = list;
    }

    /**
     * To return the filtered ArrayList
     *
     * @return
     */
    public List<String> getFilterList() {
        return filterList;
    }

}
