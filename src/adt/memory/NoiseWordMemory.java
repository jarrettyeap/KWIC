package adt.memory;

import java.util.ArrayList;

public class NoiseWordMemory {

	private ArrayList<String> noiseWordList = new ArrayList<String>();
	private static NoiseWordMemory noiseWordInstance = null;

	protected NoiseWordMemory() {
	}

	public static NoiseWordMemory getInstance( ) {
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

	public ArrayList<String> getArrayList() {
		return noiseWordList;
	}
}
