package adt.input;

import adt.memory.NoiseWordMemory;
import adt.memory.TitleMemory;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {
    /* Status Code for Menu Operation */
    private static final int TYPE_CONSOLE = 1;
    private static final int TYPE_FILE = 2;
    private static final int ERROR_NOT_INT = -1;
    private static final int MENU_IN_USE = 1;
    private static final int MENU_STOP = 0;

    private TitleMemory titleMemory = TitleMemory.getInstance();
    private NoiseWordMemory noiseMemory = NoiseWordMemory.getInstance();
    private Scanner sc;

    /**
     * To prompt the user for the type of input and handle the input requested accordingly.
     */
    public void inputMethod() {
        int status = MENU_IN_USE;

        while (status == MENU_IN_USE) {
            switch (promptType()) {
                case TYPE_CONSOLE:
                    status = handleConsoleInput();
                    break;
                case TYPE_FILE:
                    status = handleFileInput();
                    break;
                default:
                    System.out.println("ERROR: Invalid option.");
            }
        }
    }

    /**
     * Prompts the user for choice of input and return type.
     *
     * @return integer value that represents the choice of input
     */
    private int promptType() {
        try {
            sc = new Scanner(System.in);
            System.out.println("Please enter your choice of input:");
            System.out.println("1. Manual Input");
            System.out.println("2. Read Local File");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return ERROR_NOT_INT;
        }
    }

    /**
     * Read the list of titles and noise word from the user.
     */
    private int handleConsoleInput() {
        addMovieTitle();
        addNoiseWord();
        return MENU_STOP;
    }

    /**
     * To add a list of title(s) from the console into the system.
     */
    private void addMovieTitle() {
        System.out.println("Please key in the list of movie title:");
        System.out.println("Press enter to terminate.");

        ArrayList<String> titleList = new ArrayList<String>();
        String temp;
        sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
            titleList.add(temp);
        }

        titleMemory.setList(titleList);
    }

    /**
     * To add a list of ignored/noise word(s) to the system
     */
    private void addNoiseWord() {
        System.out.println("Please key in the list of noise words: ");
        System.out.println("Press enter to terminate.");

        ArrayList<String> inputArray = new ArrayList<String>();
        String temp;
        sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }
            inputArray.add(temp);
        }

        noiseMemory.setList(inputArray);
    }

    /**
     * Receive file path from the console, read string from given file and put into pipe.
     */
    private int handleFileInput() {
        System.out.println("Please enter the path of title file:");
        sc = new Scanner(System.in);
        String titleFilePath = sc.nextLine();
        List<String> titleList;

        try {
            titleList =
                Files.readAllLines(new File(titleFilePath).toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Problem reading given file path for titles.");
            return MENU_IN_USE;
        }

        System.out.println("Please enter the path of ignored words file:");
        String ignoreFilePath = sc.nextLine();
        List<String> noiseList;

        try {
            noiseList =
                Files.readAllLines(new File(ignoreFilePath).toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Problem reading given file path for ignored (noise) words.");
            return MENU_IN_USE;
        }

        titleMemory.setList(titleList);
        noiseMemory.setList(noiseList);
        return MENU_STOP;
    }
}

