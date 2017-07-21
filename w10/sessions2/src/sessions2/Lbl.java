package sessions2;

import java.util.Map;
import java.util.Queue;

/**
 * Created by mr492 on 13/07/17.
 */
public class Lbl implements Session {

    String labelName;
    Session body;
    public Lbl(String labelName, Session body) {
        this.labelName = labelName;
        this.body = body;

    }

    @Override
    public boolean check(Map<String, Session> jumpTable, Queue<Message> trace) {
        return false;
    }

    @Override
    public Session dual() {
        return null;
    }

    @Override
    public Map<String, Session> getJumpTable() {
        return null;
    }
}
