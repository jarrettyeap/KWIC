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

    /**
     * To start running KWIC
     */
    public static void setup() {
        input.addMovieTitle();
        input.addNoiseWord();

        movieTitleArray.setArrayList(duplicate.checkDuplicate(movieTitleArray.getArrayList()));
        noiseWordArray.setArrayList(duplicate.checkDuplicate(noiseWordArray.getArrayList()));

        //duplicate.checkDuplicate(movieTitleArray.getArrayList());
        //duplicate.checkDuplicate(noiseWordArray.getArrayList());
        
        circularShift.circularize(movieTitleArray.getArrayList());
        noiseFilter.noiseWordFilter(circularShift.getShiftedList());
        alphabetSort.alphabetize(noiseFilter.getFilterList());
        capitalize.capitalize(alphabetSort.getSortedList(), noiseWordArray.getArrayList());
        duplicate.checkDuplicate(capitalize.getCapitalList());

        output.print(duplicate.getDuplicateList());
    }
}
