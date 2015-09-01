package adt.shift;

import java.util.ArrayList;

public class CircularShift {

    private ArrayList<String> shiftedList = new ArrayList<String>();

    /**
     * To circularize every sentence in the ArrayList
     *
     * @param inputArray
     * @return
     */
    public void circularize(ArrayList<String> inputArray) {
        ArrayList<String> arrayShifting = new ArrayList<String> ();
        
    	for (int i = 0; i < inputArray.size(); i++) {
            String string = inputArray.get(i);
            String[] stringArray = string.split("\\s");

            for (int firstWord = 0; firstWord < stringArray.length; firstWord++) {
                StringBuilder sb = new StringBuilder();
                for (int j = firstWord; j < firstWord + stringArray.length; j++) {
                    sb.append(stringArray[j % stringArray.length]);
                    sb.append(" ");
                }
                arrayShifting.add(sb.toString());
            }
        }
    	
    	shiftedList = arrayShifting;
    }

    /**
     * To return the shifted ArrayList
     *
     * @return
     */
    public ArrayList<String> getShiftedList() {
        return shiftedList;
    }

}
