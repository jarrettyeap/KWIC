package pipeandfilter.filters;

import pipeandfilter.pipe.Pipe;

public abstract class Filter<I, O> implements Runnable {

    protected Pipe<I> inPipe;
    protected Pipe<O> outPipe;

    public Filter(Pipe<I> in, Pipe<O> out) {
        this.inPipe = in;
        this.outPipe = out;
    }

    @Override public void run() {
        passBetween();
    }

    /**
     * Used to read the input from the pipe, transform and pass output to pipe.
     */
    private void passBetween() {
        try {
            I input;
            while ((input = inPipe.get()) != null) {
                O output = transform(input);
                outPipe.put(output);
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR: Interrupted when passing data between filter");
            e.printStackTrace();
            return;
        }
        outPipe.close();
    }

    /**
     * Implemented classes must implement this method to transform data
     * received from input to output.
     */
    protected abstract O transform(I in);
}
