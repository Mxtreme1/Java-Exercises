package timetowords;

import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       try {
       Scanner scan = new Scanner(System.in);
       //getting hour and minute from scan
       int hour = scan.nextInt();
        int minute = scan.nextInt();
            String stri = "";
        //an array containing the words for their numbers (used by index)
        String[] clock = { "twelve", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven",
                "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen", "eighteen", "nineteen", "twenty",
                "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven",
                    "twenty eight", "twenty nine" };

        //if hour not between 0 and twelve its wrong input
        if (hour <= 0 || hour > 12) {
            System.out.println("Wrong Input");
            
        }
        //if it is do the following
        else if (hour > 0 && hour < 13 || minute >= 0 && minute <= 60) {
            //if its point hour print the following
            if (minute == 0) {
                System.out.println(clock[hour] + " o'clock");
            }
            //if its half past do:
            else if (minute == 30) {
                System.out.println("half past " + clock[hour]);
            } 

            else if (minute == 1) {
                    System.out.println("one minute past " + clock[hour]);
            } 
            else if (minute == 59) {
                    System.out.println("one minute to " + clock[(hour + 1) % 12]);
                }
            else if (minute == 45) {
                System.out.println("quarter to " + clock[(hour + 1) % 12]); 
            }
            else if (minute == 15) {
                System.out.println("quarter past " + clock[hour]); 
            }
            //decide if past or to
            else if (minute < 30) {
                System.out.println(clock[minute] + " minutes past " + clock[hour]);
            }
            else if (minute > 30) {
                System.out.println(clock[60 - minute] + " minutes to " + clock[(hour + 1) % 12]);
            }
            }
            scan.close();
        } catch (Exception e){
           System.out.println("Wrong Input");
       } 
   } 
}
