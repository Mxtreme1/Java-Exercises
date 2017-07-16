package sessions2;

import java.util.Map;
import java.util.Queue;

/**
 * Created by mr492 on 07/07/17.
 */
/*
    Implementation of Receive the Server side of a session.
 */
public class Rcv implements Session {
    Session rest;
    public Rcv(Session rest) {
        this.rest = rest;
    }
//    @Override
//    public boolean check(Queue<Message> trace) {
//        /*
//            Checks if a trace is accepted.
//         */
//        //Again poll is used to not need an if isEmpty
//        Message next = trace.poll();
//        if (next != null && next.getMode().equals(MessageMode.RECEIVE) && next.getKind().equals(MessageKind.DATA)) {
//            return rest.check(trace);
//        }
//        return false;
//    }

    @Override
    public boolean check(Map<String, Session> jumpTable, Queue<Message> trace) {
        return false;
    }

    @Override
    public Session dual() {
        //Recursive call.
        return new Snd(this.rest.dual());
    }

    @Override
    public Map<String, Session> getJumpTable() {
        return null;
    }
}
