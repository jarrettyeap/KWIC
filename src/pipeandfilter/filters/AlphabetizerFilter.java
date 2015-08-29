package pipeandfilter.filters;

import pipeandfilter.pipe.Pipe;

import java.util.Collections;
import java.util.List;

public class AlphabetizerFilter extends Filter<List<String>, List<String>> {

    public AlphabetizerFilter(Pipe<List<String>> in, Pipe<List<String>> out) {
        super(in, out);
    }

    /**
     * Sort the given list of string in ascending alphabetical order.
     *
     * @param input List of string from input pipe.
     * @return List of string that are sorted according to ascending alphabetical order.
     */
    @Override protected List<String> transform(List<String> input) {
        Collections.sort(input);
        return input;
    }
}
