package stdin;


import java.util.Scanner;

// read  3 ints from sdtin and print each on a new line
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int first = scan.nextInt();
        int second = scan.nextInt();
        int third = scan.nextInt();
        System.out.println(first);
        System.out.println(second);
        System.out.print(third);
    }
}
