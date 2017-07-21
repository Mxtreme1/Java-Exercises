package simplechess;

import java.util.List;

/**
 * A simple-chess board.
 */
public interface IBoard {

    /**
     * Returns true iff the board has a queen for player "player".
     */
    boolean hasQueen(Player player);

    /**
     * Returns the list of boards for the possible moves that Player "turn" can make.
     * This IBoard is not modified by "nextBoards".
     */
    List<IBoard> nextBoards(Player turn);
}
