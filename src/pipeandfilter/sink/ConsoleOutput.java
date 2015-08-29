package pipeandfilter.sink;

import pipeandfilter.pipe.Pipe;

import java.util.List;

public class ConsoleOutput implements Runnable {
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
     * Process the output into the readable format and prints into the
     * console.
     *
     * @param output
     */
    private void processAndDisplay(List<String> output) {
        String header = "--------------------------";

        System.out.println(header);
        System.out.println("KWIC Index");
        System.out.println(header);

        for (String keyword : output) {
            System.out.println(keyword);
        }

        System.out.println(header);
    }
}
