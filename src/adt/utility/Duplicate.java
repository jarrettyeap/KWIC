package adt.utility;

import java.util.ArrayList;

public class Duplicate {

    /**
     * To make sure there are no duplicates in a single ArrayList
     *
     * @param arrayList
     */
    public static ArrayList<String> checkDuplicate(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size() - 1; i++) {
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (arrayList.get(i).equalsIgnoreCase(arrayList.get(j))) {
                    arrayList.remove(j);
                    j--;
                }
            }
        }

       return arrayList;
    }
}