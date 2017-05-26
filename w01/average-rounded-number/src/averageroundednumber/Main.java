package averageroundednumber;

import java.util.Scanner;
import java.lang.Math;

// read two ints from stdin, add them and print out the result.
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float first = scan.nextFloat();
        float second = scan.nextFloat();
        float third = scan.nextFloat();
        //calculates average and rounds the value to two decimal points
        double result = Math.round(((first + second + third) /3) * 100) / 100.0d;
        System.out.printf("%.2f", result);
    }
}
