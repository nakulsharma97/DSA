class Solution {

    int n;
    int MOD = 1000000007;

    Integer[][] maxScore;
    Integer[][] ways;

    public int getint(char ch) {
        return (ch == 'S' || ch == 'E') ? 0 : ch - '0';
    }

    public boolean isValid(int i, int j, List<String> board) {
        return i >= 0 && i < n && j >= 0 && j < n &&
                board.get(i).charAt(j) != 'X';
    }

    public int[] solve(int i, int j, List<String> board) {

        if (!isValid(i, j, board))
            return new int[]{0, 0};

        if (board.get(i).charAt(j) == 'E')
            return new int[]{0, 1};

        if (maxScore[i][j] != null)
            return new int[]{maxScore[i][j], ways[i][j]};

        int bestScore = -1;
        int totalWays = 0;

        int[][] dir = {{-1, 0}, {0, -1}, {-1, -1}};

        for (int[] d : dir) {

            int ni = i + d[0];
            int nj = j + d[1];

            if (!isValid(ni, nj, board))
                continue;

            int[] res = solve(ni, nj, board);

            int score = res[0];
            int path = res[1];

            if (path == 0)
                continue;

            score += getint(board.get(i).charAt(j));

            if (score > bestScore) {
                bestScore = score;
                totalWays = path;
            } else if (score == bestScore) {
                totalWays = (totalWays + path) % MOD;
            }
        }

        if (bestScore == -1) {
            maxScore[i][j] = 0;
            ways[i][j] = 0;
        } else {
            maxScore[i][j] = bestScore;
            ways[i][j] = totalWays;
        }

        return new int[]{maxScore[i][j], ways[i][j]};
    }

    public int[] pathsWithMaxScore(List<String> board) {

        n = board.size();

        maxScore = new Integer[n][n];
        ways = new Integer[n][n];

        int[] ans = solve(n - 1, n - 1, board);

        if (ans[1] == 0)
            return new int[]{0, 0};

        return ans;
    }
}