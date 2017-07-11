package sessions;

import java.util.Map;

/**
 * Created by mr492 on 05/07/17.
 */
public class Sessions {
    public static Session send(Session rest) {
        return new Snd(rest);
    }
    public static Session recv(Session rest) {
        return new Rcv(rest);
    }
    public static Session end() {
        return new End();
    }
    public static Session select(Map<String, Session> clauses) {
        return new Slct(clauses);
    }
    public static Session branch(Map<String, Session> clauses) {
        return new Brnch(clauses);
    }
}
