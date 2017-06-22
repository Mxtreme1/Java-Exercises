package onedgame;


public class Main {
    public static boolean isWinnable(int m, boolean[] game) {
        if (m <= 0 || game.length < 1 || game[0]) {
            throw new IllegalArgumentException();
        }
        int pos = 0;
        int previous_step = 1;
        int steps_Taken_Backwards = 0;
        if (isWinnablesLittleHelper(m, pos, previous_step, steps_Taken_Backwards, game)) {
            return true;
        }
        return false;
    }
    public static boolean isWinnablesLittleHelper(int m, int pos, int last_step, int stepsplus, boolean[] game) {
        if (game.length - pos <= m + 1) {
            return true;
        }
        if (stepsplus >= m) {
            return false;
        }
        if (last_step != -1 && ! game[pos + 1]) {
            if (isWinnablesLittleHelper(m, pos + 1, 1, 0, game)) {
                return true;
            }
        }
        if (! game[pos + m]) {
            if (isWinnablesLittleHelper(m, pos + m, m, 0, game)) {
                return true;
            }
        }
        if (last_step != 1 && ! game[pos - 1]) {
            if (isWinnablesLittleHelper(m, pos - 1, -1, stepsplus + 1, game)) {
                return true;
            }
        }
        return false;
    }
}
