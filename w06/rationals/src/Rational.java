package rationals;

public class Rational {
    public Rational(long nominator, long denominator) {
        this.nom = nominator;
        this.denom = denominator;
   } 
    public Rational add(Rational r) {
        //use gcd to return correct rational
    }
    public Rational multiply(Rational r) {
        return new Rational(this.nom * r.getNominator(), this.denom * r.getDenominator());
    }
    public Rational invert(Rational r) {
        return new Rational(this.denom, this.nom);
    }
    public double toDouble() {
        return this.nom / this.denom; 
    }
    public long getNominator() {
        return this.nom; 
    }
    public long getDenominator() {
        return this.denom; 
    }

    @Override public boolean equals(Object r) {
        //euclid and then compare nom and denom
         
    }
}
