package adt.input;

import java.util.Scanner;

import adt.memory.MovieTitleMemory;
import adt.memory.NoiseWordMemory;

public class Input {
	
	private Scanner sc = new Scanner(System.in);
	MovieTitleMemory movieTitleArray = MovieTitleMemory.getInstance();
	NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();
	
	public void addMovieTitle () {
		String temp;
		while (sc.hasNextLine()) {
			temp = sc.nextLine();
			if (temp.isEmpty()) {
				break;
			}

			movieTitleArray.add(temp);
		}
	}
	
	public void addNoiseWord() {
		String temp;
		while (sc.hasNextLine()) {
			temp = sc.nextLine();
			if (temp.isEmpty()) {
				break;
			}

			noiseWordArray.add(temp);
		}
	}

}
