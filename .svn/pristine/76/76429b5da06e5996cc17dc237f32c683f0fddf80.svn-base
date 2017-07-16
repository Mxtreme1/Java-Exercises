package onedgame;

public class Main {
    /**
     * a method that checks if a game of the given type is winnable
     * @param m length of a jump
     * @param game a boolean[] containing the field
     * @return true, false true if winnable, false otherwise
     */
    public static boolean isWinnable(int m, boolean[] game) {
        if (m <= 0 || game.length < 1 || game[0]) {
            throw new IllegalArgumentException();
        }
        int pos = 0; //starting position
        int previous_step = 1; //last step 1 is step, m is jump, -1 is went one back
        int steps_Taken_Backwards = 0;
        if (isWinnablesLittleHelper(m, pos, previous_step, steps_Taken_Backwards, game)) {
            return true;
        }
        return false;
    }
    public static boolean isWinnablesLittleHelper(int m, int pos, int last_step, int stepsplus, boolean[] game) {
        //Is the player so close to the end that he can win in two moves
        if (game.length - pos <= m + 1) {
            return true;
        }
        // Has the player gone back m times
        if (stepsplus >= m) {
            return false;
        }
        //Can the player go one forward and was the last step not a move one backwards
        if (last_step != -1 && ! game[pos + 1]) {
            if (isWinnablesLittleHelper(m, pos + 1, 1, 0, game)) {
                return true;
            }
        }
        //Can the player jump
        if (! game[pos + m]) {
            if (isWinnablesLittleHelper(m, pos + m, m, 0, game)) {
                return true;
            }
        }
        //Can the player go back and has he just taken a step forward
        if (last_step != 1 && ! game[pos - 1]) {
            if (isWinnablesLittleHelper(m, pos - 1, -1, stepsplus + 1, game)) {
                return true;
            }
        }
        return false;
    }
}
