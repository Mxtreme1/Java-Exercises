package subsequence;

import java.io.CharArrayReader;
import java.lang.reflect.Array;
import java.util.*;

public enum PartialOrdering {
    LESS,
    EQUAL,
    GREATER,
    INCOMPARABLE;

    public static boolean issubstr(String s1, String s2){
        //Tests if s2 is a substring of s1
        ArrayList<Character> charList1 = new ArrayList<>(s1.length());
        ArrayList<Character> charList2 = new ArrayList<>(s2.length());
        //adds chars to array
        for (int i = 0; i < s1.length(); i++) {
           charList1.add(s1.toCharArray()[i]);
        }
        for (int i = 0; i < s2.length(); i++) {
            charList2.add(s2.toCharArray()[i]);
        }
        //tests for each char if it part of a substring
        if (charList1.size() > charList2.size()){
            for (int i = 0; i < charList2.size(); i++) {
               if (charList1.contains(charList2.get(i))){
                   charList1.subList(charList1.indexOf(charList2.get(i)) + 1, charList1.size());
                   charList2.remove(i);
               }
               else return false;
            }
            return true;
        }
        return false;
    }

    public static PartialOrdering subsequenceCompare(String s1, String s2){
        //returns the relationship between the two Strings
        if (s1.equals(s2)){
            return PartialOrdering.EQUAL;
        }
        if (s1.length() > s2.length()){
            if (issubstr(s1, s2)) {
                return PartialOrdering.GREATER;
            }
        }
        if (s2.length() > s1.length()) {
            if (issubstr(s2, s1)) {
                return PartialOrdering.LESS;
            }
        }
        return PartialOrdering.INCOMPARABLE;
    }
}

