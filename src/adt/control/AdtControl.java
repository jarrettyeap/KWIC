package adt.control;

import adt.capitalize.Capitalize;
import adt.duplicate.CheckDuplicate;
import adt.filter.NoiseFilter;
import adt.input.Input;
import adt.memory.MovieTitleMemory;
import adt.memory.NoiseWordMemory;
import adt.output.Output;
import adt.shift.CircularShift;
import adt.sort.AlphabetSort;

import java.util.ArrayList;

public class AdtControl {

    static Input input = new Input();
    static Output output = new Output();
    static CircularShift circularShift = new CircularShift();
    static NoiseFilter noiseFilter = new NoiseFilter();
    static AlphabetSort alphabetSort = new AlphabetSort();
    static CheckDuplicate duplicate = new CheckDuplicate();
    static Capitalize capitalize = new Capitalize();
    static MovieTitleMemory movieTitleArray = MovieTitleMemory.getInstance();
    static NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();
    static ArrayList<String> tempArray;

    /**
     * To start running KWIC
     */
    public static void setup() {
        input.addMovieTitle();
        input.addNoiseWord();

        duplicate.checkDuplicate(movieTitleArray.getArrayList());
        duplicate.checkDuplicate(noiseWordArray.getArrayList());

        tempArray = movieTitleArray.getArrayList();
        tempArray = circularShift.circularize(tempArray);
        tempArray = noiseFilter.noiseWordFilter(tempArray);
        tempArray = alphabetSort.alphabetize(tempArray);
        tempArray = capitalize.capitalize(tempArray, noiseWordArray.getArrayList());
        duplicate.checkDuplicate(tempArray);

        output.print(tempArray);
    }
}
