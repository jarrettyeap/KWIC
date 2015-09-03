package pipeandfilter.generator;

import pipeandfilter.control.MasterControl;
import pipeandfilter.pipe.Pipe;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;

public class ConsoleInput implements Runnable {
    /* Status Code for Menu Operation */
    private static final int TYPE_CONSOLE = 1;
    private static final int TYPE_FILE = 2;
    private static final int ERROR_NOT_INT = -1;
    private static final int MENU_IN_USE = 1;
    private static final int MENU_STOP = 0;

    private Pipe<List<String>> inputPipe;
	private Scanner sc;

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
     * Receive input from the console and put into pipe.
     */
    private int handleConsoleInput() {
        sc = new Scanner(System.in);
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
        toLowercase(ignoreList);
        MasterControl.setNoiseWords(compactList(ignoreList));

        inputPipe.put(compactList(inputList));
        inputPipe.close();
        return MENU_STOP;
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
            titleList = Files.readAllLines(new File(titleFilePath).toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Problem reading given file path for titles.");
            return MENU_IN_USE;
        }

        System.out.println("Please enter the path of ignored words file:");
        String ignoreFilePath = sc.nextLine();
        List<String> ignoreList;

        try {
            ignoreList = Files.readAllLines(new File(ignoreFilePath).toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.out.println("Problem reading given file path for ignored words.");
            return MENU_IN_USE;
        }

        MasterControl.setNoiseWords(compactList(ignoreList));

        inputPipe.put(compactList(titleList));
        inputPipe.close();
        return MENU_STOP;
    }

    /**
     * Helper method to remove all empty strings and null from the given list
     *
     * @param list the list of string
     * @return the compacted list
     */
    private List<String> compactList(List<String> list) {
        // Remove Empty String and Null Elements
        list.removeAll(Arrays.asList(null, ""));
        return list;
    }

    /**
     * Helper method to change all strings in collection to lowercase.
     *
     * @param list the list of string
     */
    private static void toLowercase(List<String> list) {
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            iterator.set(iterator.next().toLowerCase());
        }
    }
}
