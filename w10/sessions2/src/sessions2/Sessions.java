package sessions2;

import java.util.Map;
import java.util.Queue;

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
    public static Session label(String labelname, Session body) {
        return new Lbl(labelname, body);
    }
    public static Session continueWith(String labelname) {
        return new Cntnue(labelname);
    }
    public static boolean check(Session session, Queue<Message> trace) {
        return false;
    }
}
