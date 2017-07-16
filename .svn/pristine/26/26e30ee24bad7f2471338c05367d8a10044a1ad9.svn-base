package sessions;

import java.util.Queue;

/**
 * Created by thiemann on 18.06.17.
 *
 * An interface for Sessions.
 */
public interface Session {
    /**
     * Check a trace of Messages for compliance with this session. Returns
     * true if and only if the messages taken from queue comply to the
     * protocol.
     */
    public boolean check(Queue<Message> trace);

    /**
     * Returns the dual Session for this Session.
     */
    public Session dual();
}
