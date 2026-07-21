class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int n = intervals.length;
        int[][] ans = new int[n + 1][2];

        for (int i = 0; i < n; i++) {
            ans[i] = intervals[i];
        }

        ans[n][0] = newInterval[0];
        ans[n][1] = newInterval[1];
        Arrays.sort(ans, (a, b) -> a[0] - b[0]);
        int idx = 0;
        for (int i = 1; i <= n; i++) {
            if (ans[idx][1] >= ans[i][0]) {
                ans[idx][1] = Math.max(ans[idx][1], ans[i][1]);
            } else {
                idx++;
                ans[idx] = ans[i];
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }
}