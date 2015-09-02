package pipeandfilter.sink;

import pipeandfilter.pipe.Pipe;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class ConsoleOutput implements Runnable {
    private static final int TYPE_CONSOLE = 1;
    private static final int TYPE_FILE = 2;

    private Pipe<List<String>> outputPipe;

    public ConsoleOutput(Pipe<List<String>> output) {
        this.outputPipe = output;
    }

    @Override public void run() {
        receiveOutputFromPipe();
    }

    /**
     * Receive any output from the pipe and process it.
     */
    private void receiveOutputFromPipe() {
        try {
            List<String> out;
            while ((out = outputPipe.get()) != null)
                processAndDisplay(out);
        } catch (InterruptedException e) {
            System.out.println("ERROR: Problem occurred in ConsoleOutput");
            e.printStackTrace();
        }
    }

    /**
     * Prompt the user for the type of output required and perform the corresponding
     * output action.
     *
     * @param output the indexes to output
     */
    private void processAndDisplay(List<String> output) {
        System.out.println("Index Generated. Select Output Method:");
        System.out.println("1. Console");
        System.out.println("2. File");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case TYPE_CONSOLE:
                outputToConsole(output);
                break;
            case TYPE_FILE:
                outputToFile(output);
                break;
            default:
                System.out.println("ERROR: Invalid option.");
        }
    }

    /**
     * Process the output into the readable format and prints into the
     * console.
     *
     * @param output the indexes to output
     */
    private void outputToConsole(List<String> output) {
        String header = "--------------------------";

        System.out.println(header);
        System.out.println("KWIC Index");
        System.out.println(header);

        for (String keyword : output) {
            System.out.println(keyword);
        }

        System.out.println(header);
    }

    /**
     * Process the output and append into file provided by the user.
     *
     * @param output the indexes to output
     */
    private void outputToFile(List<String> output) {
        System.out.println("Enter Path for Output File:");
        Scanner sc = new Scanner(System.in);
        String outputFile = sc.nextLine();
        try {
            for (String title : output) {
                Files.write(Paths.get(outputFile), title.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            System.out.println("ERROR: Problem occurred writing to output file.");
            e.printStackTrace();
        }
    }
}
