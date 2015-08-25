package pipeandfilter.filters;

import pipeandfilter.pipe.Pipe;

import java.util.Collections;
import java.util.List;

public class AlphabetizerFilter extends Filter<List<String>, List<String>> {

    /**
     * Default constructor for AlphabetizerFilter
     *
     * @param in  input pipe
     * @param out output pipe
     */
    public AlphabetizerFilter(Pipe<List<String>> in, Pipe<List<String>> out) {
        super(in, out);
    }

    /**
     * Sort the given list of string in ascending alphabetical order
     */
    @Override protected List<String> transform(List<String> input) {
        Collections.sort(input);
        return input;
    }
}
