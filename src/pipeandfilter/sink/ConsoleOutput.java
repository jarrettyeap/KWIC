package pipeandfilter.sink;

import pipeandfilter.pipe.Pipe;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class ConsoleOutput implements Runnable {
    /* Status Code for Menu Operation */
    private static final int TYPE_CONSOLE = 1;
    private static final int TYPE_FILE = 2;
    private static final int ERROR_NOT_INT = -1;
    private static final int MENU_IN_USE = 1;
    private static final int MENU_STOP = 0;

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
        int status = MENU_IN_USE;
        while (status == MENU_IN_USE) {
            switch (promptType()) {
                case TYPE_CONSOLE:
                    status = outputToConsole(output);
                    break;
                case TYPE_FILE:
                    status = outputToFile(output);
                    break;
                default:
                    System.out.println("ERROR: Invalid option.");
            }
        }
    }

    /**
     * Prompts the user for choice of output.
     *
     * @return integer value that represents the choice of input
     */
    private int promptType() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Index Generated. Select Output Method:");
            System.out.println("1. Console");
            System.out.println("2. Append to File");
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            return ERROR_NOT_INT;
        }
    }

    /**
     * Process the output into the readable format and prints into the
     * console.
     *
     * @param output the indexes to output
     */
    private int outputToConsole(List<String> output) {
        String header = "--------------------------";

        System.out.println(header);
        System.out.println("KWIC Index");
        System.out.println(header);

        for (String keyword : output) {
            System.out.println(keyword);
        }

        System.out.println(header);
        return MENU_STOP;
    }

    /**
     * Process the output and append into file provided by the user.
     *
     * @param output the indexes to output
     */
    private int outputToFile(List<String> output) {
        System.out.println("Enter Path for Output File:");
        Scanner sc = new Scanner(System.in);
        String outputPath = sc.nextLine();

        try (PrintWriter out = new PrintWriter((new FileWriter(outputPath, true)))) {
            for (String title : output) {
                out.println(title);
            }
        } catch (IOException e) {
            System.out.println("ERROR: Problem occurred writing to output file.");
            return MENU_IN_USE;
        }

        return MENU_STOP;
    }
}
