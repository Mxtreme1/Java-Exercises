package loopinterpreter;

/**
 * Created by mr492 on 29/06/17.
 */
public class Seq implements Statement {
    Statement st1;
    Statement st2;
    public Seq(Statement s1, Statement s2) {
        this.st1 = s1;
        this.st2 = s2;
    }

    @Override
    public State run(State initial) {
        State newinitial = this.st1.run(initial);
        State newerinitial = this.st2.run(newinitial);
        return newerinitial;
    }
}
