package sessions2;

import java.util.Map;
import java.util.Queue;

/**
 * Created by mr492 on 07/07/17.
 */

/*
    Implementation of Send, which is the client side of a session.
 */
public class Snd implements Session {
    Session rest;
    public Snd(Session rest) {
        this.rest = rest;
    }

    /*@Override
    public boolean check(Queue<Message> trace) {
        *//*
        Checks if Send accepts the trace
         *//*
        //poll is used to not need an if isEmpty, because it returns null if empty
        Message next = trace.poll();
        if (next != null && next.getKind() == MessageKind.DATA && next.getMode() == MessageMode.SEND) {
            return rest.check(trace);
        }
        return false;
    }*/

    @Override
    public boolean check(Map<String, Session> jumpTable, Queue<Message> trace) {
        return false;
    }

    @Override
    public Session dual() {
        //Recursive call
        return new Rcv(this.rest.dual());
    }

    @Override
    public Map<String, Session> getJumpTable() {
        return null;
    }
}
