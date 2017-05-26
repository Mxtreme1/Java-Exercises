package uniquechars;

import java.util.*;

public class Main {
   public static int uniqueChars(Map<String, Integer> cache, String input) {
       //Tests how many different chars are in a String
    List<Character> list = new ArrayList<Character>(); //list of chars already counted
    int counter = 0;

    if (!cache.containsKey(input)) {

        //for each char in the String check if it already counted and if not add it and increment counter
    for (int i = 0; i < input.length(); i++) {
       if (!list.contains(input.toCharArray()[i])) {
          list.add(input.toCharArray()[i]);
            counter++;
       }
    }
    cache.put(input, counter); //the String is added to the Map with its unique char number
    return counter;
    }
    else return cache.get(input);

   } 
    public static List<Integer> allUniqueChars(Map<String, Integer> cache, List<String> input) {
       //Checks for each element in List how many unique chars it has
    List<Integer> list = new ArrayList<Integer>();
    for (int i = 0; i < input.size(); i++) {
        list.add(Main.uniqueChars(cache, input.get(i))); // adds the number of uniques to the list
    }
    return list; 
  } 
  public static List<Integer> allUniqueChars(List<String> input) {
       //Checks for each elem how many uniques it has and creates a Map for it
    Map<String, Integer> cache = new HashMap<String, Integer>();
    List<Integer> list = new ArrayList<Integer>();

    for (int i = 0; i < input.size(); i++) {
        list.add(Main.uniqueChars(cache, input.get(i))); // adds the number of uniques to the list
    }
    return list;
  }
}
