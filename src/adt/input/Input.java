package adt.input;

import adt.memory.MovieTitleMemory;
import adt.memory.NoiseWordMemory;

import java.util.Scanner;

public class Input {

    private Scanner sc = new Scanner(System.in);
    MovieTitleMemory movieTitleArray = MovieTitleMemory.getInstance();
    NoiseWordMemory noiseWordArray = NoiseWordMemory.getInstance();

    /**
     * To add a movie title to the system
     */
    public void addMovieTitle() {
        String temp;
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }

            movieTitleArray.add(temp);
        }
    }

    /**
     * To add a noise word to the system
     */
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
