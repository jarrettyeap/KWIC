package adt.memory;

import adt.utility.Duplicate;

import java.util.ArrayList;
import java.util.List;

public class NoiseWordMemory {

    private List<String> noiseWordList = new ArrayList<String>();
    private static NoiseWordMemory noiseWordInstance = null;

    protected NoiseWordMemory() {
    }

    /**
     * Get the singleton instance of the noise memory module.
     *
     * @return object of the initialized module
     */
    public static NoiseWordMemory getInstance() {
        if (noiseWordInstance == null) {
            noiseWordInstance = new NoiseWordMemory();
        }
        return noiseWordInstance;
    }

    /**
     * Set the list of noise words in the memory.
     *
     * @param list the titles to store
     */
    public void setList(List<String> list) {
        noiseWordList = Duplicate.checkDuplicate(list);
    }

    /**
     * Get the list of noise words currently stored in the memory.
     *
     * @return list of noise words
     */
    public List<String> getNoiseList() {
        return noiseWordList;
    }
}
