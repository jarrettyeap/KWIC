package pipeandfilter.generator;

import pipeandfilter.control.MasterControl;
import pipeandfilter.pipe.Pipe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Runnable {
    private static final int TYPE_CONSOLE = 1;
    private static final int TYPE_FILE = 2;

    private Pipe<List<String>> inputPipe;

    public ConsoleInput(Pipe<List<String>> input) {
        this.inputPipe = input;
    }

    @Override public void run() {
        putInputIntoPipe();
    }

    /**
     * Accept input from the user either by manual input or read from file
     * and put into output pipe.
     */
    private void putInputIntoPipe() {
        switch (promptType()) {
            case TYPE_CONSOLE:
                handleConsoleInput();
                break;
            case TYPE_FILE:
                handleFileInput();
                break;
        }
    }

    /**
     * Prompts the user for choice of input and return type.
     *
     * @return integer value that represents the choice of input
     */
    private int promptType() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your choice of input:");
        System.out.println("1. Manual Input");
        System.out.println("2. Read Local File");
        return sc.nextInt();
    }

    /**
     * Receive input from the console and put into pipe.
     */
    private void handleConsoleInput() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<String>();

        System.out.println("Please enter the titles (separated by newline): ");
        System.out.println("[Enter empty line to end title insertion]");

        String sentence;

        while (sc.hasNextLine()) {
            sentence = sc.nextLine();
            if (sentence.isEmpty()) {
                break;
            }

            inputList.add(sentence);
        }

        System.out.println("Please enter the list of ignore words (separated by space or comma): ");
        String ignoreWords = sc.nextLine();

        ArrayList<String> ignoreList =
            new ArrayList<String>(Arrays.asList(ignoreWords.split("(,\\s)+")));
        MasterControl.setNoiseWords(ignoreList);

        inputPipe.put(inputList);
        inputPipe.close();
    }

    /**
     * Receive file path from the console, read string from given file and put into pipe.
     */
    private void handleFileInput() {
        System.out.println("Please enter the path of title file:");
        Scanner sc = new Scanner(System.in);
        String titleFilePath = sc.nextLine();
        List<String> titleList = new ArrayList<String>();

        try {
            titleList = compactList(Files.readAllLines(new File(titleFilePath).toPath()));
        } catch (IOException e) {
            System.out.println("Problem reading given file path for titles.");
            e.printStackTrace();
        }

        System.out.println("Please enter the path of ignored words file:");
        String ignoreFilePath = sc.nextLine();
        List<String> ignoreList = new ArrayList<String>();

        try {
            ignoreList = compactList(Files.readAllLines(new File(ignoreFilePath).toPath()));
        } catch (IOException e) {
            System.out.println("Problem reading given file path for ignored words.");
            e.printStackTrace();
        }

        MasterControl.setNoiseWords(ignoreList);

        inputPipe.put(titleList);
        inputPipe.close();
    }

    /**
     * Helper method to remove all empty strings and null from the given list
     *
     * @param list
     * @return the compacted list
     */
    private List<String> compactList(List<String> list) {
        // Remove Empty String and Null Elements
        list.removeAll(Arrays.asList(null, ""));
        return list;
    }
}
