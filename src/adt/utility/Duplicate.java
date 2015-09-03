package adt.utility;

import java.util.List;

/**
 * Utility class to offer some shared functions to other concrete classes
 */
public class Duplicate {
    /**
     * To make sure there are no duplicates in a single list.
     *
     * @param list the list to check duplicates for
     */
    public static List<String> checkDuplicate(List<String> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equalsIgnoreCase(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }
        return list;
    }
}
