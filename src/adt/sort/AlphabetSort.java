package adt.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphabetSort {
    private List<String> sortedList = new ArrayList<String>();

    /**
     * Performs an alphabetical sort on the given input list.
     *
     * @param list the list to sort and store
     */
    public void alphabetize(List<String> list) {
        List<String> tempList = new ArrayList<String>(list);
        Collections.sort(tempList);
        sortedList = tempList;
    }

    /**
     * Returns the sorted list in ascending order in the object.
     *
     * @return the list stored in the current class object
     */
    public List<String> getSortedList() {
        return sortedList;
    }
}

