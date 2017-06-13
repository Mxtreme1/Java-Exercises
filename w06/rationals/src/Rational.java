package rationals;

public class Rational {
    long nom;
    long denom;
    public Rational(long nominator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException();
        }
        this.nom = nominator;
        this.denom = denominator;
   }
    private Rational cancel() {
        long thisnewnom;
        long thisnewdenom;
        double shortened = 1;
        for (long i = 2; i <= Math.min(this.nom, this.denom); i++) {
            if (this.denom % i == 0 && this.nom % i == 0) {
                shortened = i;
            }
        }
        thisnewnom = (long)(this.nom / shortened);
        thisnewdenom = (long)(this.denom /shortened);
        return new Rational(thisnewnom, thisnewdenom);
    }
    private long euclid(long n, long m) {
        while (m != 0) {
          long o = n % m;
          n = m;
          m = o;
       } 
        return n;
    }
    private long lcm(long m, long n) {
        return Math.abs(n * m) / euclid(n, m);
    }
    public Rational add(Rational r) {
        //use lcm to return correct rational
        long mult = lcm(this.getDenominator(), r.getDenominator());
        long multthis = mult / this.getDenominator();
        long multr = mult / r.getDenominator();
        return new Rational(this.getNominator() * multthis + r.getNominator() * multr, mult);
        
    }
    public Rational multiply(Rational r) {
        return new Rational(this.nom * r.getNominator(), this.denom * r.getDenominator());
    }
    public Rational invert() {
        if (this.nom == 0) {
            throw new IllegalArgumentException();
        }
        return new Rational(this.denom, this.nom);
    }
    public double toDouble() {
        return this.nom / this.denom; 
    }
    public long getNominator() {
        return this.cancel().nom;
    }
    public long getDenominator() {
        return this.cancel().denom;
    }

    @Override public boolean equals(Object r) {
        //euclid and then compare nom and denom
            if (this.cancel().getNominator() == ((Rational) r).cancel().getNominator() && this.cancel().getDenominator() == ((Rational) r).cancel().getDenominator()) {
                return true;
            }
            return false;
    }
}
