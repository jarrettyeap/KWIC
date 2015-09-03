package adt.input;

import adt.memory.MovieTitleMemory;
import adt.memory.NoiseWordMemory;

import java.util.ArrayList;
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

        ArrayList<String> inputArray = new ArrayList<String>();
        String temp;
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }

            inputArray.add(temp);
        }

        movieTitleArray.setArrayList(inputArray);
    }

    /**
     * To add a noise word to the system
     */
    public void addNoiseWord() {
        System.out.println("Please key in the list of noise words: ");
        System.out.println("Press enter to terminate.");

        ArrayList<String> inputArray = new ArrayList<String>();
        String temp;
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
            inputArray.add(temp);
            noiseWordArray.add(temp);
        }

        noiseWordArray.setArrayList(inputArray);
    }

    public void inputMethod() {
        int inputType;
        System.out.println("Please enter your choice of input:");
        System.out.println("1. Manual Input");
        System.out.println("2. Read Local File");

        if (sc.hasNextInt()) {
            inputType = sc.nextInt();
            sc.nextLine();
            if (inputType == 1) {
                addMovieTitle();
                addNoiseWord();
            } else if (inputType == 2) {
                System.out.println("File Input");
            }
        } else {
            System.out.println("Invalid Input");
        }
    }
}

