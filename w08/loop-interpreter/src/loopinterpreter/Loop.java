package loopinterpreter;

/**
 * Created by mr492 on 29/06/17.
 */
public class Loop implements Statement {
    Expression e;
    Statement st;
    public Loop(Expression exp, Statement s) {
        this.e = exp;
        this.st = s;
    }

    @Override
    public State run(State initial) {
        State cur = initial;
        while (this.e.eval(cur) != 0) {
            cur = this.st.run(cur);
        }
        return cur;
    }
}
