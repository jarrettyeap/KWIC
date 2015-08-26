package pipeandfilter.control;

import pipeandfilter.filters.*;
import pipeandfilter.generator.ConsoleInput;
import pipeandfilter.pipe.Pipe;
import pipeandfilter.sink.ConsoleOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Setup and controls the pipeline of the application.
 */
public class MasterControl {
    // Pipes used in the pipeline.
    private static Pipe<List<String>> inputToWordCase;
    private static Pipe<List<String>> wordCaseToCircular;
    private static Pipe<List<String>> circularToNoise;
    private static Pipe<List<String>> noiseToAlpha;
    private static Pipe<List<String>> alphaToOutput;

    // Filters used in the pipeline.
    private static AlphabetizerFilter alphabetizer;
    private static CircularShifterFilter circularShifter;
    private static NoiseWordFilter noiseWord;
    private static WordCaseFilter wordCase;


    // Collection of pipe and filter pointers for batch processing.
    private static List<Pipe> pipes;
    private static List<Filter> filters;

    // Generator and sink used to capture input and produce output in console
    private static ConsoleInput input;
    private static ConsoleOutput output;

    /**
     * Setup pipeline if needed and initiate pipeline sequence.
     */
    public static void setup() {
        setupPipeline();
        startPipeline();
    }

    /**
     * Set the properties of noise word and word case filter
     * to use the given filter list.
     *
     * @param filterList the list of ignore/noise words to filter
     */
    public static void setNoiseWords(List<String> filterList) {
        noiseWord.setFilterWords(filterList);
        wordCase.setFilterWords(filterList);
    }

    private static void setupPipeline() {
        if (input == null && output == null) {
            input = new ConsoleInput(inputToWordCase);
            output = new ConsoleOutput(alphaToOutput);
        }

        if (pipes == null && filters == null) {
            // Create the required pipes.
            inputToWordCase = new Pipe<List<String>>();
            wordCaseToCircular = new Pipe<List<String>>();
            circularToNoise = new Pipe<List<String>>();
            noiseToAlpha = new Pipe<List<String>>();
            alphaToOutput = new Pipe<List<String>>();

            pipes.add(inputToWordCase);
            pipes.add(wordCaseToCircular);
            pipes.add(circularToNoise);
            pipes.add(noiseToAlpha);
            pipes.add(alphaToOutput);

            // Create the required filters and connect the pipes to the filters.
            alphabetizer = new AlphabetizerFilter(noiseToAlpha, alphaToOutput);
            circularShifter = new CircularShifterFilter(wordCaseToCircular, circularToNoise);
            noiseWord = new NoiseWordFilter(circularToNoise, noiseToAlpha);
            wordCase = new WordCaseFilter(inputToWordCase, wordCaseToCircular);

            filters.add(alphabetizer);
            filters.add(circularShifter);
            filters.add(noiseWord);
            filters.add(wordCase);
        }
    }

    private static void startPipeline() {
        int envProcessorCount = Runtime.getRuntime().availableProcessors();
        ExecutorService es = Executors.newFixedThreadPool(envProcessorCount);
        List<Callable<Object>> callables = new ArrayList<Callable<Object>>();

        for (Filter filter : filters) {
            callables.add(Executors.callable(filter));
        }

        callables.add(Executors.callable(input));
        callables.add(Executors.callable(output));

        try {
            es.invokeAll(callables);
        } catch (InterruptedException e) {
            cleanup();
        }

    }

    private static void cleanup() {

    }
}
