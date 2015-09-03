package adt.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabetSort {

    List<String> sortedList = new ArrayList<String>();

    /**
     * To perform an alphabetical sort on the ArrayList
     *
     * @param inputList
     * @return
     */
    public void alphabetize(List<String> inputList) {
        Collections.sort(inputList);
        sortedList = inputList;
    }

    /**
     * To return the sorted ArrayList
     *
     * @return
     */
    public List<String> getSortedList() {
        return sortedList;
    }
}

