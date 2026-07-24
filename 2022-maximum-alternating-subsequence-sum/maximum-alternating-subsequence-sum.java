class Solution {

    int n;
    long[][] t;

    public long solve(int idx, int[] nums, boolean iseven) {

        if (idx >= n) {
            return 0;
        }

        if (t[idx][iseven ? 1 : 0] != -1) {
            return t[idx][iseven ? 1 : 0];
        }

        long skip = solve(idx + 1, nums, iseven);

        long val = nums[idx];
        if (iseven == false) {
            val = -val;
        }

        long take = solve(idx + 1, nums, !iseven) + val;

        return t[idx][iseven ? 1 : 0] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {

        n = nums.length;
        t = new long[n + 1][2];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], -1);
        }

        return solve(0, nums, true);
    }
}