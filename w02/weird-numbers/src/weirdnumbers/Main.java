package weirdnumbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();


        //ckeck if number is uneven or between 6 and 20 or negative
        if (first % 2 != 0 || first >= 6 && first <= 20 || first < 0) {
            System.out.println("Weird");
        }
        else {
            System.out.println("Not Weird");
        }
        scan.close();
    }
}
