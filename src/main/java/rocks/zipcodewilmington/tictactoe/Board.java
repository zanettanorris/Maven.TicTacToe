package rocks.zipcodewilmington.tictactoe;

/**
 * @author leon on 6/22/18.
 */
public class Board {
    Character[][] board;
    boolean isWinner = false;
    String winner = "";


    public Board(Character[][] matrix) {
        this.board = matrix;
    }

    public Boolean isInFavorOfX() {
        return getWinner() == "X";
    }

    public Boolean isInFavorOfO() {
        return getWinner() == "O";
    }

    public Boolean isTie() {
        return getWinner() == "";
    }


    public String getWinner() {
        for (int i = 0; i < 3; i++) {
            //checking for rows
            checkValues(board[i][0], board[i][1], board[i][2]);
            if (isWinner) {
                return winner;
            }
        }
        for (int i = 0; i < 3; i++) {
            //checking for columns
            checkValues(board[0][i], board[1][i], board[2][i]);
            if (isWinner) {
                return winner;
            }
        }

        // checking diagonal
        checkValues(board[0][0], board[1][1], board[2][2]);
        if (isWinner) {
            return winner;
        }

        checkValues(board[0][2], board[1][1], board[2][0]);
        if (isWinner) {
            return winner;
        }

        return "";

    }

    private void checkValues(Character charOne, Character charTwo, Character charThree) {

        if (charOne == charTwo && charTwo == charThree && charOne != ' ') {
            if (charOne == 'X') {
                isWinner = true;
                winner = "X";
            } else if (charOne == 'O') {
                isWinner = true;
                winner = "O";
            } else {
                winner = "";
            }
        }
    }
}
