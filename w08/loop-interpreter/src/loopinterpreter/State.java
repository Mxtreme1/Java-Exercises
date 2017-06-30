package loopinterpreter;

import java.util.HashMap;

/**
 * Created by thiemann on 18.06.17.
 */
public class State extends HashMap<String, Integer> {
    /* is this a good idea?
    @Override
    public Integer get(Object key) {
        if (this.containsKey(key)) {
            return super.get(key);
        } else {
            return 0;
        }
    }
    */

    /*
    No it isn't, as there is no reason to return 0 if the key isn't contained.
    The overridden method is therefore not really better as the original and can thus be ignored.
     */
}
