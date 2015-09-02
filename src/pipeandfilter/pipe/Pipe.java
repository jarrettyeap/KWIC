package pipeandfilter.pipe;

import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Pipe<E> {
    private Queue<E> pipeBuffer = new LinkedList<E>();

    private boolean openForWriting = true;
    private boolean openForReading = true;

    public synchronized boolean put(E object) {
        if (!openForWriting)
            throw new RuntimeException(new IOException("Pipe has been closed"));

        boolean result = pipeBuffer.add(object);
        notify();
        return result;
    }

    public synchronized E get() throws InterruptedException {
        if (!openForReading)
            throw new NoSuchElementException("Pipe is closed and empty");

        while (pipeBuffer.isEmpty())
            wait();

        E object = pipeBuffer.remove();
        if (object == null)
            openForReading = false;
        return object;
    }

    public synchronized void close() {
        openForWriting = false;
        pipeBuffer.add(null);
        notify();
    }

    public synchronized void open() {
        pipeBuffer.clear();
        openForWriting = true;
        openForReading = true;
        notify();
    }
}
