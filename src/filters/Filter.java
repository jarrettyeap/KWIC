package filters;

import java.io.EOFException;
import pipe.Pipe;

public class Filter {
	
	protected Pipe inPipe;
	protected Pipe outPipe;
	
	public void setIn(Pipe data) {
		inPipe = data;
	}
	
	public void setOut(Pipe data) {
		outPipe = data;
	}
	
	public void write(String string) {
		if (string == null) {
			outPipe.close();
			return;
		}
		outPipe.write(string);
	}
	
	public String read() throws EOFException {
		return inPipe.read();
	}

}
