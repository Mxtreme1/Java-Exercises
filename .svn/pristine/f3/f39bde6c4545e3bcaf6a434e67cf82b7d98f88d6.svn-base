package conditionalfunctions;

import static java.lang.Math.abs;

public class Functions {

    public static String turbineControl(double f) {
        String stri = "";
        //checks if f is greater/smaller than 49/51
        if (f <= 49 || f >= 51) {
          stri = "DISCONNECT";  
        }   
        //checks if f is close to 50
        else if (abs(f - 50 ) <= 0.001) {
            stri = "STEADY";
        }
        //checks if f is smaller than 50
        else if (f < 50) {
            stri = "MORE_WATER"; 
        }
        // useless comment as code is easy to read
        else if (f > 50) {
            stri = "LESS_WATER"; 
        }
        return stri;
    }
}
