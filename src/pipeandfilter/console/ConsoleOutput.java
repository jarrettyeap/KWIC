package pipeandfilter.console;

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

    private void receiveOutputFromPipe() {
        try {
            List<String> out;
            while ((out = outputPipe.get()) != null)
                processAndDisplay(out);
        } catch (InterruptedException e) {

        }
    }

    /**
     * Process the list of string for display purposes in the console
     *
     * @param output
     */
    private void processAndDisplay(List<String> output) {

    }
}
