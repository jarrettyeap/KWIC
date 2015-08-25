package pipeandfilter.filters;

import java.io.EOFException;
import java.util.Arrays;

public class NoiseWordFilter extends Filter {

	public static final String noiseWords[] = {"is", "the", "of", "and", "as", "a", "after" };

	protected void transform() {
		while (true) {
			try {
				String string = read();
				String tokens[] = string.split("\\s");
				
				if(Arrays.asList(noiseWords).contains(tokens[0].toLowerCase()))
					continue;
				
				write (string);
				
			} catch (EOFException e) {
				write(null);
				break;
			}
		}
	}
}
