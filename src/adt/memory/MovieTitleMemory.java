package adt.memory;

import adt.utility.Duplicate;

import java.util.ArrayList;
import java.util.List;

public class MovieTitleMemory {

    private List<String> movieTitles = new ArrayList<String>();
    private static MovieTitleMemory movieTitleInstance = null;

    protected MovieTitleMemory() {
    }

    public static MovieTitleMemory getInstance() {
        if (movieTitleInstance == null) {
            movieTitleInstance = new MovieTitleMemory();
        }
        return movieTitleInstance;
    }

    public void add(String title) {
        movieTitles.add(title);
    }

    public void delete(int position) {
        movieTitles.remove(position);
    }

    public String get(int position) {
        return movieTitles.get(position);
    }

    public void setArrayList(List<String> list) {
        movieTitles = Duplicate.checkDuplicate(list);
    }

    public List<String> getMovieTitles() {
        return movieTitles;
    }

}
