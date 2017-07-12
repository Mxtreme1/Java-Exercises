package rainfall;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    /**
     * Creates the average for each series in readings if it exists
     * @param readings a list of values to which the means need to be found
     * @return an average for each series
     */
    public static List<Optional<Double>> rainfall(List<Double> readings) {
        Double sum = 0.0;
        Double read = 0.0;
        List<Optional<Double>> opts = new ArrayList<>();
        for (Double r : readings) {
            //for all values check if they mark the ending of a reading or are negative(if yes discard)
            //else add them to the correct sum and take the average
            if (r != -999) {
                if (r >= 0) {
                    sum += r;
                    read++;
                }
                else {
                    continue;
                }
            }
            else {
                if (read == 0) {
                    //if no values were read it adds an empty Optional
                    opts.add(Optional.empty());
                }
                else {
                    opts.add(Optional.of((sum / read)));
                    sum = 0.0;
                    read = 0.0;
                }
                continue;
            }
        }
        return opts;
    }
}
