package listoperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Implementation of multiple common list operations taken in via stdin
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       String command = "commander";
       String word1 = "exists";
       String word2 = "delimiter";
       List<String> list = new ArrayList<String>();
       String[] parts;
       String line;

       //Extracts the command from stdin
       while (scan.hasNextLine()) {
           line = scan.nextLine();
           parts = line.split(" ");
           if (parts.length > 0) {
               command = parts[0];
               if (parts.length > 1) {
                   word1 = parts[1];
                   if (parts.length > 2) {
                       word2 = parts[2];
                   }
               }
           }
           //Checks which command was entered and executes it accordingly if entered is invalid
           //it gives out an error over stdout
           if (word1.matches("\\w+") && word2.matches("\\w+")) {
               if (command.equalsIgnoreCase("append") && word1 != "exists") {
                   list.add(word1);

               } else if (command.equalsIgnoreCase("pop")) {
                   if (list.size() > 0) list.remove(list.size() - 1);

                   else System.out.println("\nDOES NOT COMPUTE");
               } else if (command.equalsIgnoreCase("set")) {
                   try {
                       list.set(Integer.parseInt(word1), word2);
                   } catch (Exception e) {
                       System.out.println("\nDOES NOT COMPUTE");
                   }

               } else if (command.equalsIgnoreCase("remove-first")) list.remove(word1);

               else if (command.equalsIgnoreCase("remove-all")) {
                   while (list.contains(word1)) list.remove(word1);

               } else if (command.equalsIgnoreCase("print")) {
                   System.out.print("\n");
                   System.out.print("::");
                   for (int i = 0; i < list.size(); i++) System.out.print(" " + list.get(i));

               } else if (command.equalsIgnoreCase("sort")) Collections.sort(list);

               else if (command.equalsIgnoreCase("reverse")) Collections.reverse(list);
           }
           else System.out.println("\nINVALID COMMAND");
       }
       scan.close();
   }
}
