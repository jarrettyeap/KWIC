package generator;

import pipe.Pipe;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Runnable {
    private Pipe<List<String>> inputPipe;
	private Scanner sc;
	private List<String> inputArray;

    public ConsoleInput(Pipe<List<String>> input) {
        this.inputPipe = input;
    }

    @Override public void run() {
        putInputIntoPipe();
    }

    private void putInputIntoPipe() {
    	sc = new Scanner(System.in);
    	
    	System.out.println("Please input the titles: ");
		String temp;
		inputArray = null;
		while (sc.hasNextLine()) {
			temp = sc.nextLine();
			if (temp.isEmpty()) {
				break;
			}

			inputArray.add(temp);
		}
		
		inputPipe.put(inputArray);
    }
}
