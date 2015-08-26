package pipeandfilter.filters;

import pipeandfilter.pipe.Pipe;

import java.util.ArrayList;
import java.util.List;

public class NoiseWordFilter extends Filter<List<String>, List<String>> {
    private List<String> filterList;

    public NoiseWordFilter(Pipe<List<String>> in, Pipe<List<String>> out) {
        super(in, out);
    }

    public void setFilterWords(List<String> list) {
        this.filterList = list;
    }

    protected List<String> transform(List<String> input) {
        List<String> outputList = new ArrayList<String>();
        for (String sentence : input) {
            String[] tokens = sentence.split("\\s", 2);
            if (!filterList.contains(tokens[0].toLowerCase()))
                outputList.add(sentence);
        }
        return outputList;
    }
}
