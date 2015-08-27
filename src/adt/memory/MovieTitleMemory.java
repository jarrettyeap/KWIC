package adt.memory;

import java.util.ArrayList;

public class MovieTitleMemory {

	private ArrayList<String> movieTitleList = new ArrayList<String>();
	private static MovieTitleMemory movieTitleInstance = null;
	
	protected MovieTitleMemory() {
	}

	public static MovieTitleMemory getInstance( ) {
		if (movieTitleInstance == null) {
			movieTitleInstance = new MovieTitleMemory();
		}
		return movieTitleInstance;
	}
	
	public void add(String title) {
		movieTitleList.add(title);
	}
	
	public void delete(int position) {
		movieTitleList.remove(position);
	}
	
	public String get(int position) {
		return movieTitleList.get(position);
	}
	
	public ArrayList<String> getArrayList() {
		return movieTitleList;
	}
	
}
