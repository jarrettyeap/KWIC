package pipeandfilter.filters;

import pipeandfilter.pipe.Pipe;

import java.util.ArrayList;
import java.util.List;

public class CircularShifterFilter extends Filter<List<String>, List<String>> {
    public CircularShifterFilter(Pipe<List<String>> in, Pipe<List<String>> out) {
        super(in, out);
    }

    /**
     * @param input
     * @return
     */
    protected List<String> transform(List<String> input) {
        List<String> shiftedList = new ArrayList<String>();

        for (String sentence : input) {
            String[] tokens = sentence.split("\\s");

            for (int start = 0; start < tokens.length; start++) {
                StringBuilder sb = new StringBuilder();
                for (int i = start; i < start + tokens.length; i++) {
                    sb.append(tokens[i % tokens.length]);
                    sb.append(" ");
                }
                shiftedList.add(sb.toString());
            }
        }

        return shiftedList;
    }
}
