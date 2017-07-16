package sessions2;

import java.util.Map;
import java.util.Queue;

/**
 * Created by mr492 on 07/07/17.
 */
public class End implements Session {

    @Override
    public boolean check(Map<String, Session> jumpTable, Queue<Message> trace) {
        return trace.isEmpty();
    }

    @Override
    public Session dual() {
        return this;
    }

    @Override
    public Map<String, Session> getJumpTable() {
        return null;
    }
}
