package pipeandfilter.generator;

import pipeandfilter.pipe.Pipe;

import java.util.ArrayList;
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
        ArrayList<String> inputArray = new ArrayList<String>();

        System.out.println("Please input the titles: ");
        String temp;

        while (sc.hasNextLine()) {
            temp = sc.nextLine();
            if (temp.isEmpty()) {
                break;
            }

            inputArray.add(temp);
        }

        inputPipe.put(inputArray);
    }
}
