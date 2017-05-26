package secondhighest;

public class Main {
    //Returns the secondhighest number in an array of ints
   public static int secondHighest(int[] numbers) {
    if (numbers.length < 2) return Integer.MIN_VALUE;//Under two numbers => no second highest. Min_Val is returned
    else {
    int highest = Integer.MIN_VALUE;//All new highest and secondhighest have to be bigger than this value
    int second = Integer.MIN_VALUE;
    //for every number in the given numbers
    for (int i = 0; i < numbers.length; i++) {
        //Checks if number is the new highest
        if (numbers[i] > highest) {
        second = highest;
        highest = numbers[i];
        }
        //Check if number is not highest, but new second highest
        else if (numbers[i] > second && numbers[i] != highest) second = numbers[i];
    }
    return second;
    }
   } 
}
