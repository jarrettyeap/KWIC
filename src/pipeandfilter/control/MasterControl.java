package pipeandfilter.control;

import pipeandfilter.filters.*;
import pipeandfilter.pipe.Pipe;

import java.util.List;

/**
 * Setup and controls the pipeline of the application.
 */
public class MasterControl {
    // Pipes used in the pipeline.
    Pipe<List<String>> inputToWordCase;
    Pipe<List<String>> wordCaseToCircular;
    Pipe<List<String>> circularToNoise;
    Pipe<List<String>> noiseToAlpha;
    Pipe<List<String>> alphaToOutput;


    // Filters used in the pipeline.
    AlphabetizerFilter alphabetizer;
    CircularShifterFilter circularShifter;
    NoiseWordFilter noiseWord;
    WordCaseFilter wordCase;


    // Collection of pipe and filter pointers for batch processing.
    List<Pipe> pipes;
    List<Filter> filters;

    /**
     * Setup pipeline if needed and initiate pipeline sequence.
     */
    public static void setup() {
        setupPipeline();
        initiateConsole();
    }

    private static void setupPipeline() {

    }

    private static void initiateConsole() {

    }

    /**
     * Set the properties of noise word and word case filter
     * to used the given filter list.
     *
     * @param filterList the list of ignore/noise words to filter
     */
    public static void setNoiseWords(List<String> filterList) {

    }
}
