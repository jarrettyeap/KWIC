package adt.control;

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
	static MovieTitleMemory movieTitleArray = MovieTitleMemory.getInstance();
	static NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();
	
	public static void setup() {
		System.out.println("Please key in the list of movie title: ");
		System.out.println("Press enter to terminate.");
		input.addMovieTitle();
		
		System.out.println("Please key in the list of noise words: ");
		System.out.println("Press enter to terminate.");
		input.addNoiseWord();
		
		circularShift.circularizer(movieTitleArray.getArrayList());
		noiseFilter.noiseWordFilter(circularShift.getArrayList());
		alphabetSort.alphabetize(noiseFilter.getFilterList());
		
		output.print(alphabetSort.getSortedList());
	}
}
