package adt.capitalize;

import java.util.ArrayList;

public class Capitalize {

    private ArrayList<String> capitalizeList = new ArrayList<String>();

    public ArrayList<String> capitalize(ArrayList<String> inputArray) {
        for (int i = 0; i < inputArray.size(); i++) {
            String string = inputArray.get(i);
            String[] stringArray = string.split("\\s");
            stringArray[0] =
                stringArray[0].substring(0, 1).toUpperCase() + stringArray[0].substring(1);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < stringArray.length; j++) {
                sb.append(stringArray[j]);
                sb.append(" ");
            }

            capitalizeList.add(sb.toString().trim());

        }

        return capitalizeList;
    }
}
