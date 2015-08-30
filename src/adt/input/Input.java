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
        System.out.println("Please key in the list of movie title: ");
        System.out.println("Press enter to terminate.");

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
        System.out.println("Please key in the list of noise words: ");
        System.out.println("Press enter to terminate.");

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
