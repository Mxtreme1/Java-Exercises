package sessions2;

import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * An interface for Sessions.
 */
public interface Session {
    /**
     * Check a trace of Messages for compliance with this session. Returns
     * true iff and only if the messages taken from queue comply to the
     * protocol.
     *
     * @param jumpTable The jump-table for "continueWith" Sessions.
     * @param trace The trace to check.
     */
    public boolean check(Map<String, Session> jumpTable, Queue<Message> trace);

    /**
     * Returns the dual Session for this Session.
     */
    public Session dual();

    /**
     * Returns the jump-table for for this session. The jump-table is a map
     * from label names that occur in this session to the body-sessions of those labels.
     *
     * The label names in the session have to be unique.
     * @return The jump table
     * @throws IllegalArgumentException if the label names in this Session
     * are not unique.
     */
    public Map<String, Session> getJumpTable();
}
