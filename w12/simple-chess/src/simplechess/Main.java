package simplechess;

import java.util.List;

public class Main {

    /**
     * Return true iff the game of simple-chess on "board" is winnable by white in "turns" steps.
     * White has the first turn.
     */
    public static boolean winnable(IBoard board, int turns) {
       return winnable(board, Player.WHITE, turns);
    }

    public static boolean winnable(IBoard board, Player turn, int turns) {
        if (!board.hasQueen(Player.WHITE)) {
            // White has lost the queen -> lost
            return false;
        } else if (!board.hasQueen(Player.BLACK)){
            // Black has lost the queen -> won
            return true;
        } else if (turns == 0){
            // No turns yet and black still has a queen -> cannot win
            return false;
        } else {
            List<IBoard> nextBoards = board.nextBoards(turn);
            if (turn.equals(Player.WHITE)) {
                // It's white's turn; if there is any winning nextBoard, white can win
                for (IBoard nextBoard : nextBoards) {
                    if (winnable(nextBoard, turn.next(), turns-1)) {
                        return true;
                    }
                }
                return false;
            } else {
                // It's black's turn; if there is any nextBoard that cannot be won, white may loose
                for (IBoard nextBoard : nextBoards) {
                    if (!winnable(nextBoard, turn.next(), turns-1)) {
                        return false;
                    }
                }
                return true;
            }
        }
    }

}
