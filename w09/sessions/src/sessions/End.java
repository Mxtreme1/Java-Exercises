package sessions;

import java.util.Queue;

/**
 * Created by mr492 on 07/07/17.
 */
public class End implements Session {
    @Override
    public boolean check(Queue<Message> trace) {
        return trace.isEmpty();
    }

    @Override
    public Session dual() {
        return this;
    }
}
