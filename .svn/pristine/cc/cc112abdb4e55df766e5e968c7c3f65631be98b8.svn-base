package loopinterpreter;

/**
 * Created by mr492 on 29/06/17.
 */
public class Statements {
    /*
    Implementation of Statements of the Loop programming language.
     */

    //Assigns an Expression to a string (like a variable with a string as name)
    public static Statement assign(String name, Expression exp) {
        return new Assign(name, exp);
    }

    //Processes two Statements sequentially
    public static Statement seq(Statement s1, Statement s2) {
        return new Seq(s1, s2);
    }

    //Processes Statement 1 if condition is met (Expression != 0) else Statement 2
    public static Statement cond(Expression exp, Statement s1, Statement s2) {
        return new Cond(exp, s1, s2);
    }

    //Loops a Statement while Expression != 0 with Statement s
    public static Statement loop(Expression exp, Statement s) {
        return new Loop(exp, s);
    }
}
