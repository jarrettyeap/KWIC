package pipeandfilter.generator;

import pipeandfilter.control.MasterControl;
import pipeandfilter.pipe.Pipe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Runnable {
    private Pipe<List<String>> inputPipe;

    public ConsoleInput(Pipe<List<String>> input) {
        this.inputPipe = input;
    }

    @Override public void run() {
        putInputIntoPipe();
    }

    private void putInputIntoPipe() {
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
}
