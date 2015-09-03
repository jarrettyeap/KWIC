package pipeandfilter.pipe;

import java.io.IOException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class Pipe<E> {
    private Queue<E> pipeBuffer = new LinkedList<E>();

    private boolean openForWriting = true;
    private boolean openForReading = true;

    /**
     * Puts data into the pipe buffer if it is open for writing.
     *
     * @param object object of generic type E
     * @return true if added into buffer successfully else false
     */
    public synchronized boolean put(E object) {
        if (!openForWriting)
            throw new RuntimeException(new IOException("Pipe has been closed"));

        boolean result = pipeBuffer.add(object);
        notify();
        return result;
    }

    /**
     * Retrieve data from pipe buffer if it is open for reading and buffer
     * is not empty.
     *
     * @return the object retrieved from the pipe buffer
     * @throws InterruptedException
     */
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

    /**
     * Closed the pipe for write operation and clear buffer.
     */
    public synchronized void close() {
        openForWriting = false;
        pipeBuffer.add(null);
        notify();
    }

    /**
     * Open the pipe for read and write operations and clear buffer.
     */
    public synchronized void open() {
        pipeBuffer.clear();
        openForWriting = true;
        openForReading = true;
        notify();
    }
}
