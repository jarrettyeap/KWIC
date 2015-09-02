package adt.sort;

import java.util.ArrayList;
import java.util.Collections;

public class AlphabetSort {

    ArrayList<String> sortedList = new ArrayList<String>();

    /**
     * To perform an alphabetical sort on the ArrayList
     *
     * @param inputList
     * @return
     */
    public void alphabetize(ArrayList<String> inputList) {
        Collections.sort(inputList);
        sortedList = inputList;
    }

    /**
     * To return the sorted ArrayList
     *
     * @return
     */
    public ArrayList<String> getSortedList() {
        return sortedList;
    }
}

