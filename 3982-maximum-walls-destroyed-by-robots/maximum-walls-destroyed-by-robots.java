import java.util.*;

class Solution {

    int[][] dp;

    // Binary search based count (fast)
    public int countwalls(int[] walls, int l, int r) {
        int left = lowerBound(walls, l);
        int right = upperBound(walls, r);
        return right - left;
    }

    // first index >= target
    public int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    // first index > target
    public int upperBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int maxWalls(int[] robots, int[] distance, int[] walls) {

        int n = robots.length;

        int[][] robodist = new int[n][2];
        for (int i = 0; i < n; i++) {
            robodist[i][0] = robots[i];
            robodist[i][1] = distance[i];
        }

        Arrays.sort(robodist, (a, b) -> a[0] - b[0]);
        Arrays.sort(walls);

        int[][] range = new int[n][2];

        for (int i = 0; i < n; i++) {
            int pos = robodist[i][0];
            int d = robodist[i][1];

            int leftlimit = (i == 0) ? 1 : robodist[i - 1][0] + 1;
            int rightlimit = (i == n - 1) ? (int) 1e9 : robodist[i + 1][0] - 1;

            range[i][0] = Math.max(pos - d, leftlimit);
            range[i][1] = Math.min(pos + d, rightlimit);
        }

        dp = new int[n][2];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(walls, robodist, range, 0, 0);
    }

    public int solve(int[] walls, int[][] robodist, int[][] range, int i, int prevdir) {

        if (i == robodist.length) return 0;

        if (dp[i][prevdir] != -1) return dp[i][prevdir];

        int leftstart = range[i][0];

        if (prevdir == 1 && i > 0) {
            leftstart = Math.max(leftstart, range[i - 1][1] + 1);
        }

        int lefttake = countwalls(walls, leftstart, robodist[i][0])
                + solve(walls, robodist, range, i + 1, 0);

        int righttake = countwalls(walls, robodist[i][0], range[i][1])
                + solve(walls, robodist, range, i + 1, 1);

        return dp[i][prevdir] = Math.max(lefttake, righttake);
    }
}