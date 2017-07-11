package sessions;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * Created by mr492 on 07/07/17.
 */
/*
    Implementation of Select.
 */
public class Slct implements Session {
    Map<String, Session> clauses;
    public Slct(Map<String, Session> clauses) {
        this.clauses = clauses;
    }
    @Override
    public boolean check(Queue<Message> trace) {
        /*
            Checks if the sent command is in clauses and the session is accepted if yes accept.
         */
        //Again poll used for not needing an if isEmpty
        Message next = trace.poll();
        if (next != null && next.getKind() == MessageKind.COMMAND && next.getMode() == MessageMode.SEND && clauses.containsKey(next.getPayLoad())) {
            return clauses.get(next.getPayLoad()).check(trace);
        }
        return false;
    }

    @Override
    public Session dual() {
        //Recursive call.
        Map<String, Session> dualedClauses = new HashMap<>();
        for (String key : clauses.keySet()) {
            dualedClauses.put(key, clauses.get(key).dual());
        }
        return new Brnch(dualedClauses);
    }
}
