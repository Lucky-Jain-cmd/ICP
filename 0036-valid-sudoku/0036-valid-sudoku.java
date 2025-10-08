class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = board.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j])) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char valChar) {
        // Temporarily clear this cell
        board[row][col] = '.';

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == valChar) return false;
            if (board[i][col] == valChar) return false;

            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if (board[r][c] == valChar) return false;
        }
        board[row][col] = valChar;
        return true;
    }
}
