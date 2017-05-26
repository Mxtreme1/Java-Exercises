package addtwoints;

import java.util.Scanner;

// read two ints from stdin, add them and print out the result.
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // takes the first and second argument from the stdin, adds and prints them
        int first = scan.nextInt();
        int second = scan.nextInt();
        int third = first + second;
        System.out.println(third);


    }
}
