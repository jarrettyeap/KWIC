package generator;

import pipe.Pipe;

import java.util.List;

public class ConsoleInput implements Runnable {
    private Pipe<List<String>> inputPipe;

    public ConsoleInput(Pipe<List<String>> input) {
        this.inputPipe = input;
    }

    @Override public void run() {
        putInputIntoPipe();
    }

    private void putInputIntoPipe() {
        // Read Input
        // Write into Pipe
    }
}
