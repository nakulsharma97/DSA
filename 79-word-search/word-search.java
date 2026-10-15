class Solution {
        int n, m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word,
                       int r, int c, int i) {

        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= n || c >= m) {
            return false;
        }

        if (board[r][c] != word.charAt(i)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found =
                dfs(board, word, r - 1, c, i + 1) ||
                dfs(board, word, r + 1, c, i + 1) ||
                dfs(board, word, r, c - 1, i + 1) ||
                dfs(board, word, r, c + 1, i + 1);

        board[r][c] = temp;

        return found;
    }
}
