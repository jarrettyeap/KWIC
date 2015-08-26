import pipeandfilter.control.MasterControl;

import java.util.Scanner;

public class KWIC {
    public static void main(String[] args) {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose the following architectures:");
            System.out.println("1. Pipe and Filter");
            System.out.println("2. Abstract Data Type");
            System.out.println("3. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    // Call and pass control to ADT
                    break;
                case 2:
                    MasterControl.setup();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}
