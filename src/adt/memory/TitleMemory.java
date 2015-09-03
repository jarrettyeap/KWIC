package adt.memory;

import adt.utility.Duplicate;

import java.util.ArrayList;
import java.util.List;

public class TitleMemory {

    private List<String> titleList = new ArrayList<String>();
    private static TitleMemory memoryInstance = null;

    protected TitleMemory() {
    }

    /**
     * Get the singleton instance of the title memory module.
     *
     * @return object of the initialized module
     */
    public static TitleMemory getInstance() {
        if (memoryInstance == null) {
            memoryInstance = new TitleMemory();
        }
        return memoryInstance;
    }

    /**
     * Set the list of titles in the memory.
     *
     * @param list the titles to store
     */
    public void setList(List<String> list) {
        titleList = Duplicate.checkDuplicate(list);
    }

    /**
     * Get the list of titles currently stored in the memory.
     *
     * @return list of titles
     */
    public List<String> getTitleList() {
        return titleList;
    }
}
