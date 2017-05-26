package anagrams;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //Checks if two Strings given via stdin are anagrams if yes it prints it
    public static void main(String[] s) {
        Scanner scan = new Scanner(System.in);
        String fir;
        String sec;
        ArrayList<Character> first = new ArrayList<Character>();
        ArrayList<Character> second = new ArrayList<Character>();
        //If only one or zero arguments in stdin it is no anagram
        if (scan.hasNext()) {
            fir = scan.next(); 
            if (scan.hasNext()) sec = scan.next();
            else {
                System.out.println("Not anagrams");
                return;
            }
        }
        else {
            System.out.println("Not anagrams");
            return;
        }

        //Adds all chars to an arraylist for easier comparison
        for (char c : fir.toLowerCase().toCharArray()) first.add(c);
        for (char c : sec.toLowerCase().toCharArray()) second.add(c);

        //Checks if size is equal and all chars are also in the other String
        if (second.size() == first.size()) {
           for (int i = 0; i < first.size(); i++) {
                if (!second.contains(first.get(i))) {
                    System.out.println("Not anagrams");
                    return;
                }
           } 
        }
        else {
            System.out.println("Not anagrams");
            return;
        }
        System.out.println("Anagrams");
        scan.close();
   } 
}
