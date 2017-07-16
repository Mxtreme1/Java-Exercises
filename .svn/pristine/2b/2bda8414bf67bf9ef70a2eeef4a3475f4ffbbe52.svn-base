package sessions;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ExampleTests {

    /**
     * Test Session for buying at most one book against a trace buying 0
     * book, from the view of the client.
     *
     * The helper functions newAddBooksTrace, addCheckoutToBooks and
     * assertTrace are defined below.
     */
    @Test
    public void bookShopClient1Trace0() {
        Session bookShopClientSession = selectNBooks(1);

        Queue<Message> trace = newAddBooksTrace(
                Collections.emptyList());
        assertTrace(false, trace, bookShopClientSession);

        trace = newAddBooksTrace(Collections.singletonList("Game of Thrones"));
        addCheckoutToBooks(trace);
        assertTrace(true, trace, bookShopClientSession);
    }

    /**
     * Test Session for buying at most one book against a trace buying 1
     * book, from the view of the client.
     */
    @Test
    public void bookShopClient1Trace1() {
        Session bookShopClientSession = selectNBooks(1);

        Queue<Message> trace = newAddBooksTrace(
                Collections.singletonList("Game of Thrones"));
        assertTrace(false, trace, bookShopClientSession);

        trace = newAddBooksTrace(Collections.singletonList("Game of Thrones"));
        addCheckoutToBooks(trace);
        assertTrace(true, trace, bookShopClientSession);
    }

    /**
     * Test Session for buying at most one book against a trace buying 1
     * book, from the view of the server.
     */
    @Test
    public void bookShopServer1Trace1() {
        Session bookShopServerSession = selectNBooks(1).dual();

        Queue<Message> trace = newAddBooksTrace(
                Collections.singletonList("Game of Thrones"),
                MessageMode.RECEIVE);
        assertTrace(false, trace, bookShopServerSession);

        trace = newAddBooksTrace(Collections.singletonList("Game of Thrones"),
                                 MessageMode.RECEIVE);
        addCheckoutToBooks(trace, MessageMode.RECEIVE);
        assertTrace(true, trace, bookShopServerSession);
    }

    /**
     * Test Session for buying at most one book against a trace buying 2
     * books, from the view of the client.
     */
    @Test
    public void bookShopClient1Trace2() {
        Session bookShopClientSession = selectNBooks(1);

        Queue<Message> trace = newAddBooksTrace(
                Arrays.asList("Game of Thrones",
                              "Types and Programming Languages"));
        addCheckoutToBooks(trace);
        assertTrace(false, trace, bookShopClientSession);
    }

    /**
     * Test Session for buying at most two books against trace of buying 1
     * book, from the view of the client.
     */
    @Test
    public void bookShopClient2Trace1() {
        Session bookShopClientSession = selectNBooks(2);
        Queue<Message> trace = newAddBooksTrace(
                Collections.singletonList("Game of Thrones"));
        addCheckoutToBooks(trace);
        assertTrace(true, trace, bookShopClientSession);
    }

    /**
     * Session for 2 items against trace with two items
     */
    @Test
    public void bookShop2ItemTrace2Item() {
        Session bookShopClientSession = selectNBooks(2);

        Queue<Message> trace = newAddBooksTrace(
                Arrays.asList("Game of Thrones",
                              "Types and Programming Languages"));
        assertTrace(false, trace, bookShopClientSession);

        trace = newAddBooksTrace(
                Arrays.asList("Game of Thrones",
                              "Types and Programming Languages"));
        addCheckoutToBooks(trace);
        assertTrace(true, trace, bookShopClientSession);
    }
    /**
     * Create a bookshop session for buying at most "n" books.
     */
    private Session selectNBooks(int n) {
        // for zero books, we allow a single choice: CHECKOUT
        Map<String,Session> checkoutMap = new HashMap<>();
        // CHECKOUT requires two sends, followed by end.
        checkoutMap.put("CHECKOUT", Sessions.send(Sessions.send(Sessions.end())));

        Session currentSession = Sessions.select(checkoutMap);
        for (int i = 0; i < n; i++) {
            // for i+1 books, we give the choice between "CHECKOUT" and
            // "ADD_ITEM", followed by the session for i books (currentSession).
            Map<String,Session> selectMap = new HashMap<>(checkoutMap);
            selectMap.put("ADD_ITEM", Sessions.send(currentSession));
            currentSession = Sessions.select(selectMap);
        }
        return currentSession;
    }

    /**
     * Create a message queue from a list of book titles by sending/receiving
     * ADD_ITEM followed by the book title.
     */
    private Queue<Message> newAddBooksTrace(List<String> books, MessageMode mode) {
        Queue<Message> result = new LinkedList<>();
        for (String bookName : books) {
            result.add(new Message("ADD_ITEM",
                                   MessageKind.COMMAND,
                                   mode));
            result.add(new Message(bookName,
                                   MessageKind.DATA,
                                   mode));
        }
        return result;
    }

    private Queue<Message> newAddBooksTrace(List<String> books) {
        return newAddBooksTrace(books, MessageMode.SEND);
    }

    /**
     * Add CHECKOUT messages to the end of a message queue (send or receive).
     */
    private void addCheckoutToBooks(Queue<Message> trace, MessageMode mode) {
        trace.add(new Message("CHECKOUT", MessageKind.COMMAND, mode));
        trace.add(new Message("12345678", MessageKind.DATA, mode));
        trace.add(new Message("Georges Koehler Allee 79",
                              MessageKind.DATA,
                              mode));
    }
    private void addCheckoutToBooks(Queue<Message> trace) {
        addCheckoutToBooks(trace, MessageMode.SEND);
    }

    /**
     * Assert that "session.check(trace)" == "shouldAccept" with informative
     * error message.
     */
    private void assertTrace(boolean shouldAccept,
                             Queue<Message> trace,
                             Session session)  {
        String msg =
                "Trace: " + trace.toString() + "\n"
                + "Session: " + session.toString() + "\n";
        if (shouldAccept) {
            assertTrue(msg, session.check(trace));
        } else {
            assertFalse(msg, session.check(trace));
        }
    }

}
