package inttostring;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        //if scan contains an int print it
        if (scan.hasNextInt()) {
            System.out.println("Found int: " + String.valueOf(scan.nextInt()));
        } else {
            System.out.println("No int");
        }
        scan.close();
    }
}
