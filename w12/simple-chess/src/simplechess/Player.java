package simplechess;

/**
 * The players of simple-chess.
 */
public enum Player {
    WHITE,

    BLACK;
    public Player next() {
        if (this.equals(WHITE)) {
            return BLACK;
        } else {
            return WHITE;
        }

    }
}
