package pipeandfilter.filters;

import pipeandfilter.pipe.Pipe;

import java.util.ArrayList;
import java.util.List;

public class WordCaseFilter extends Filter<List<String>, List<String>> {
    private List<String> filterList;

    public void setFilterWords(List<String> list) {
        this.filterList = list;
    }

    public WordCaseFilter(Pipe<List<String>> in, Pipe<List<String>> out) {
        super(in, out);
    }

    protected List<String> transform(List<String> input) {
        List<String> outputList = new ArrayList<String>();
        for (String sentence : input) {
            sentence = sentence.toLowerCase();
            String[] tokens = sentence.split("\\s");

            if (!filterList.contains(tokens[0])) {
                sentence = sentence.substring(0, 1).toUpperCase() + sentence.substring(1);
            }
            outputList.add(sentence);
        }
        return outputList;
    }
}
