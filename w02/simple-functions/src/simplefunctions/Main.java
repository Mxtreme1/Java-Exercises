package simplefunctions;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
   public static double distanceOrigin(double x, double y){
       //distance of a vector is calculated and returned using formula
       double first = pow(x, 2) + pow(y, 2);
       double second = sqrt(first);
       return second;
   } 
    public static double cubeVolume(double x) {
        //cube volume is length of side to the third
       return pow(x, 3); 
    }
    public static double cubeSurface(double x) {
        //cube surface is six times a single surface (side length squared)
       return 6 * pow(x, 2); 
    } 
    public static String stringInsert(String str, int pos) {
        //splits the string into two and inserts "_" in pos
        return  str.substring(0, pos) + "_" + str.substring(pos, str.length()); 
    }
    public static double capacitance(double epsilonR, double A, double d) {
        // calculation using standard formula
        return ((8.85 * pow(10, -12) * epsilonR * A) / d);   
    }
}
