package loopinterpreter;

/**
 * Created by mr492 on 29/06/17.
 */
public class Assign implements Statement {
    String name;
    Expression e;
    public Assign(String name, Expression exp) {
        this.name = name;
        this.e = exp;
    }

    @Override
    public State run(State initial) {
        //Puts the evaluated Expression into the Hashmap with the name as key
        initial.put(this.name, this.e.eval(initial));
        return initial;
    }
}
