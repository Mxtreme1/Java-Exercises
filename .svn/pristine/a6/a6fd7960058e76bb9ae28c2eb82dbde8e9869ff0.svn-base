package sessions;

/**
 * Mode of a message in a trace: a message in a trace can either be sent, or received.
 * Created by thiemann on 18.06.17.
 */
public enum MessageMode {
    SEND, RECEIVE;

    /**
     * Returns the dual mode to this mode.
     */
    public MessageMode dual() {
        switch(this) {
            case SEND: return RECEIVE;
            case RECEIVE: return SEND;
            default: throw new RuntimeException("Impossible case");
        }
    }
}
