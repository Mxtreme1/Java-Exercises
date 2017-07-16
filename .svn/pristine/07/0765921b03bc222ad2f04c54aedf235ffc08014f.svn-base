package loopinterpreter;

/**
 * Created by mr492 on 29/06/17.
 */
public class Cond implements Statement {
    Expression e;
    Statement st1;
    Statement st2;
    public Cond(Expression exp, Statement s1, Statement s2) {
        this.e = exp;
        this.st1 = s1;
        this.st2 = s2;
    }

    @Override
    public State run(State initial) {
        if (this.e.eval(initial) != 0) {
            return this.st1.run(initial);
        }
        else {
            return this.st2.run(initial);
        }
    }
}
