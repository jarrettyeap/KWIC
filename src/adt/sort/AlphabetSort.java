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
        sortedList = inputList;
        Collections.sort(sortedList);
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

