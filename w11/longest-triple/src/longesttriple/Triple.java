package longesttriple;

import java.util.Arrays;
import java.util.List;

/**
 * A triple of strings
 */
public class Triple {

    private final String s1;
    private final String s2;
    private final String s3;

    public Triple(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    /**
     * The length of the concatenated elements of this triple.
     */
    public int totalLen() {
        return s1.length() + s2.length() + s3.length();
    }

    public String get1() {
        return s1;
    }

    public String get2() {
        return s2;
    }

    public String get3() {
        return s3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triple triple = (Triple) o;

        if (s1 != null ? !s1.equals(triple.s1) : triple.s1 != null)
            return false;
        if (s2 != null ? !s2.equals(triple.s2) : triple.s2 != null)
            return false;
        return s3 != null ? s3.equals(triple.s3) : triple.s3 == null;
    }

    @Override
    public int hashCode() {
        int result = s1 != null ? s1.hashCode() : 0;
        result = 31 * result + (s2 != null ? s2.hashCode() : 0);
        result = 31 * result + (s3 != null ? s3.hashCode() : 0);
        return result;
    }

    public String toString() {
        return " *{" + this.get1() + " " + this.get2() + " " + this.get3() + "}* ";
    }
}
