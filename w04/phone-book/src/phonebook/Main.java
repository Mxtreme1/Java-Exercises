package phonebook;

import java.util.*;

public class Main {
    //Implementation of a Phonebook, which can take in names and a number and gives out the number to a name
  public static void main(String[] args) {
    int n; //number of entries
    Scanner scan = new Scanner(System.in);
    Map<String, String> book = new HashMap<String, String>();
    String first; //will later be names and the telephone number
    String second;
    String third;
    
    try {
        n = scan.nextInt(); // number of entries is scanned
        if (n != 0) {
           for (int i = 0; i < n; i++) {
                first = scan.next();
                third = scan.next();
                if (!third.matches("\\d+")) { //checks if there only is one name if not scan the phone number
                   second = third;
                    third = scan.next();
                    // checks if there is a valid number
                    if (third.matches("\\d+")) first = first.concat(" " + second);

                    else System.out.println("Error: cannot parse phone book.");
                }
            if (book.containsKey(first)) System.out.println("Warning: overwriting entry for: " + first);

            book.put(first, third); // Enters the name(s) and phone number into the phone book
           } 
        }
        
    } catch(Exception e){
        System.out.println("Error: cannot parse phone book.");
    }  
    String nothing = scan.nextLine(); // Prevents an error caused
    while (scan.hasNextLine()) {
        String cur_name = scan.nextLine();
        if (!cur_name.matches("\\s*$")) { //checks if the line only contains spaces if yes ignore it
            if (cur_name.matches("[A-Za-z]+( [A-Za-z]+)?")) { // checks if the name entered is valid
                if (book.containsKey(cur_name)) {
                    System.out.println(cur_name + " = " + book.get(cur_name)); //prints name and number
                }
                else System.out.println("Not found: " + cur_name);
            }
             else System.out.println("Not a name: " + cur_name);
        }
    }
    scan.close();
  }  
}
