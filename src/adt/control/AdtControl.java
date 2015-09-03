package adt.control;

import adt.capitalize.Capitalize;
import adt.filter.NoiseFilter;
import adt.input.Input;
import adt.memory.TitleMemory;
import adt.output.Output;
import adt.shift.CircularShift;
import adt.sort.AlphabetSort;

public class AdtControl {
    private static Input input = new Input();
    private static Output output = new Output();
    private static CircularShift circularShift = new CircularShift();
    private static NoiseFilter noiseFilter = new NoiseFilter();
    private static AlphabetSort alphabetSort = new AlphabetSort();
    private static Capitalize capitalize = new Capitalize();
    private static TitleMemory titleMemory = TitleMemory.getInstance();

    /**
     * Setup the master control to run the workflow in the system.
     */
    public static void setup() {
        input.inputMethod();
        circularShift.circularize(titleMemory.getTitleList());
        noiseFilter.noiseWordFilter(circularShift.getShiftedList());
        alphabetSort.alphabetize(noiseFilter.getFilterList());
        capitalize.capitalize(alphabetSort.getSortedList());
        output.print(capitalize.getCapitalList());
    }
}
