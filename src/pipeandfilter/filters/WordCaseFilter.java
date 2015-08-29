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

    /**
     * Transform the given input by capitalizing keywords and lower casing non-keywords.
     *
     * @param input List of string from input pipe.
     * @return List of string that are capitalized accordingly.
     */
    protected List<String> transform(List<String> input) {
        List<String> outputList = new ArrayList<String>();
        for (String sentence : input) {
            sentence = sentence.toLowerCase();
            String[] tokens = sentence.split("\\s");
            StringBuilder sb = new StringBuilder();
            for (String token : tokens) {
                if (!filterList.contains(token)) {
                    token = token.substring(0, 1).toUpperCase() + token.substring(1);
                }
                sb.append(token + ' ');
            }
            outputList.add(sb.toString().trim());
        }
        return outputList;
    }
}
