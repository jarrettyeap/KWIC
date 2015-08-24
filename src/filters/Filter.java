package filters;

import pipe.Pipe;

public abstract class Filter<I, O> implements Runnable {

    protected Pipe<I> inPipe;
    protected Pipe<O> outPipe;

    public Filter(Pipe<I> in, Pipe<O> out) {
        this.inPipe = in;
        this.outPipe = out;
    }

    @Override
    public void run() {
        transform();
    }

    /**
     * Implemented classes must implement this method to transform data
     * received from input to output
     */
    protected abstract void transform();
}
