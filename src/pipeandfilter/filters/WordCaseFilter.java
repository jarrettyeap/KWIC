package pipeandfilter.filters;

import pipeandfilter.pipe.Pipe;

import java.util.List;

public class WordCaseFilter extends Filter<List<String>, List<String>> {
    public WordCaseFilter(Pipe<List<String>> in, Pipe<List<String>> out) {
        super(in, out);
    }

    protected List<String> transform(List<String> input) {
        return null;
    }
}
