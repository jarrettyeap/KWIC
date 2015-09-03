package adt.memory;

import adt.utility.Duplicate;

import java.util.ArrayList;
import java.util.List;

public class NoiseWordMemory {

    private List<String> noiseWordList = new ArrayList<String>();
    private static NoiseWordMemory noiseWordInstance = null;

    protected NoiseWordMemory() {
    }

    public static NoiseWordMemory getInstance() {
        if (noiseWordInstance == null) {
            noiseWordInstance = new NoiseWordMemory();
        }
        return noiseWordInstance;
    }

    public void add(String noiseWord) {
        noiseWordList.add(noiseWord);
    }

    public void delete(int position) {
        noiseWordList.remove(position);
    }

    public String get(int position) {
        return noiseWordList.get(position);
    }

    public List<String> getArrayList() {
        return noiseWordList;
    }

    public void setArrayList(List<String> list) {
        noiseWordList = Duplicate.checkDuplicate(list);
    }
}
