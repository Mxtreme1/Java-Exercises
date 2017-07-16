package sessions;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by mr492 on 07/07/17.
 */
/*
    Implementation of Branch.
 */
public class Brnch implements Session{
    Map<String, Session> clauses;
    public Brnch(Map<String, Session> clauses) {
        this.clauses = clauses;
    }
    @Override
    public boolean check(Queue<Message> trace) {
        /*
            Checks if the received command is in clauses and the session is accepted if yes accept.
         */
        //poll used to not need an if isEmpty
        Message next = trace.poll();
        if (next != null && next.getKind().equals(MessageKind.COMMAND) && next.getMode().equals(MessageMode.RECEIVE) && clauses.containsKey(next.getPayLoad())) {
            return clauses.get(next.getPayLoad()).check(trace);
        }
        return false;
    }

    @Override
    public Session dual() {
        //Recursive call
        Map<String, Session> dualedClauses = new HashMap<>();
        for (String key : clauses.keySet()) {
            dualedClauses.put(key, clauses.get(key).dual());
        }
        return new Brnch(dualedClauses);
    }
}
