package rationals;

public class Rational {
    /**
     *Implementation for rational numbers
     * Constructed with: Long, Long which are numerator and denominator they are element of Z
     */

    private long nominator;
    private long denominator;

    public Rational(long nominator, long denominator) {
        /**
         * Constructor for a rational number
         * Takes two longs as numerator and denominator
         */
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.nominator = nominator;
	    this.denominator = denominator;
        this.cancel(); // simplifies the rational if possible
        // 0/1 is the standard representation for 0
        if (this.nominator == 0) {
            this.denominator = 1; 
        }
        //brings the sign up to the numerator
        else if (this.denominator < 0 && this.nominator > 0) {
            this.denominator = - this.denominator; 
            this.nominator = - this.nominator;
        }
        //if both numerator and denominator are negative the whole rational is positive
        else if (this.nominator < 0 && this.denominator < 0) {
            this.nominator = - this.nominator;
            this.denominator = - this.denominator; 
        }
    }
    
    public long getNominator() {
    	return this.nominator;
    }

    public long getDenominator() {
        return this.denominator;
    }

    public Long euclid(long a, long b) {
        //Implementation of the iterative version of the euclidian algorithm (Kudos go to Wikipedia for the Pseudocode)
        long h;
        while (b != 0) {
            h = a % b;
            a = b;
            b = h;
        }
        return a;
    }

    public void cancel() {
        // A method to simplify an instance of a rational number usiing euclid
        long shorten = euclid(this.nominator, this.denominator);
        this.nominator = this.nominator / shorten;
        this.denominator = this.denominator / shorten;
        //These are the same as in the constructor granting a coherent representation of rational numbers
        if (this.nominator == 0) {
            this.denominator = 1;
        }
        else if (this.denominator < 0 && this.nominator > 0) {
            this.denominator = - this.denominator;
            this.nominator = - this.nominator;
        }
        else if (this.nominator < 0 && this.denominator < 0) {
            this.nominator = - this.nominator;
            this.denominator = - this.denominator;
        }
    }

    public Rational add(Rational r) {
        //Adds to instances of Rational together using euclid and then simplifying the rational
        this.cancel();
        r.cancel();
        long first = euclid(r.denominator, this.getDenominator());
        long newnum = Math.addExact(Math.multiplyExact(this.denominator / first, r.getNominator()), Math.multiplyExact(this.nominator, r.getDenominator() / first));
        long newdenom = Math.multiplyExact(this.denominator, r.getDenominator() / first);
        Rational added = new Rational(newnum, newdenom);
        added.cancel();
        return added;
        
    }
    public Rational multiply(Rational r) {
        //Multiplies two rationals with each other using euclid and simplifies the result
        this.cancel();
        r.cancel();
        long l = euclid(this.nominator, r.getDenominator());
        long re = euclid(this.denominator, r.getNominator());
        long newnum = Math.multiplyExact(this.nominator / l, r.getNominator() / re);
        long newdenom = Math.multiplyExact(this.denominator / re, r.getDenominator() / l);
        Rational multiplied = new Rational(newnum, newdenom);
        multiplied.cancel();
        return multiplied;
    }

    public Rational invert() {
        return new Rational(this.denominator, this.nominator);
    }

    public double toDouble() {
        return this.nominator / this.denominator;
    }

    public String toString() {
        return this.nominator + " / " + this.denominator;
    }

    @Override public boolean equals(Object r) {
        //new equals checking if the simplified representations of the rationals are the same
        if (this == r) {
            return true;
        }
        if (r instanceof Rational) {
            ((Rational) r).cancel();
            this.cancel();
            if (this.nominator == ((Rational) r).getNominator() && this.denominator == ((Rational) r).getDenominator()) {
                return true;
            }
            return false;
        }
        return false;
    }
}
