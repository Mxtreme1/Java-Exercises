package sessions2;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ExampleTests {
    /**
     * Create a bookshop session for the client.
     */
    Session bookShopClient() {
        // construct the select map
        Map<String,Session> selectMap = new HashMap<>();
        //   in case ADD_ITEM we send the book title and continue at the label "start"
        selectMap.put("ADD_ITEM", Sessions.send(Sessions.continueWith("start")));
        //   in case CHECKOUT we send the credit card number, send the
        // address, and then end the session
        selectMap.put("CHECKOUT", Sessions.send(Sessions.send(Sessions.end())));

        // the entire session is an entry point "start" that contains the "select".
        return Sessions.label("start", Sessions.select(selectMap));
    }

    /**
     * Create an extended bookshop session for the client. It extends
     * bookShopClient with the possibility to correct address and creditcard
     * number: just before ending the session, we can send the Commands CONFIRM or GO_BACK_TO_CHECKOUT.
     *  - in case of CONFIRM the session ends
     *  - in case of GO_BACK_TO_CHECKOUT, we (basically) continue with CHECKOUT
     */
    Session extendedBookShopClient() {
        // construct the select map
        Map<String,Session> selectMap = new HashMap<>();
        //   in case ADD_ITEM we send the book title and continue at the label "start"
        selectMap.put("ADD_ITEM", Sessions.send(Sessions.continueWith("start")));
        //   in case CHECKOUT we implement the extended functionality.
        Map<String,Session> confirmSelectMap = new HashMap<>();
        // end on CONFIRM
        confirmSelectMap.put("CONFIRM", Sessions.end());
        // go to "checkout" on GO_BACK_TO_CHECKOUT
        confirmSelectMap.put("GO_BACK_TO_CHECKOUT", Sessions.continueWith("checkout"));
        Session checkoutBody =
                Sessions.label("checkout",
                               // send twice, like before, then select a confirmation command
                               Sessions.send(
                                      Sessions.send(
                                              Sessions.select(confirmSelectMap))));
        selectMap.put("CHECKOUT", checkoutBody);

        // the entire session is an entry point "start" that contains the "select".
        return Sessions.label("start", Sessions.select(selectMap));

    }

    /**
     * Test Session for buying at most one book against a trace buying 0
     * book, from the view of the client.
     *
     * The helper functions newAddBooksTrace, addCheckoutToBooks and
     * assertTrace are defined below.
     */
    @Test
    public void bookShopClient1Trace0() {
        Session bookShopClientSession = bookShopClient();

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
        Session bookShopClientSession = bookShopClient();

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
        Session bookShopServerSession = bookShopClient().dual();

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
     * Test Session for buying a number of books.
     */
    @Test
    public void bookShopClient2Trace1() {
        Session bookShopClientSession = bookShopClient();
        int n = 11; // number of books
        List<String> someBookTitles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            someBookTitles.add("Book #" + i);
        }
        Queue<Message> trace = newAddBooksTrace(someBookTitles);
        addCheckoutToBooks(trace);
        assertTrace(true, trace, bookShopClientSession);
    }

    /**
     * Session for 2 items against trace with two items
     */
    @Test
    public void bookShop2ItemTrace2Item() {
        Session bookShopClientSession = bookShopClient();

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
            assertTrue(msg, Sessions.check(session, trace));
        } else {
            assertFalse(msg, Sessions.check(session, trace));
        }
    }

}
