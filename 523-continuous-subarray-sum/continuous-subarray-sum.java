class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int pref = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            pref += nums[i];
            if (k != 0) {
                int sum = pref % k;
                if (map.containsKey(sum)) {
                    int prev = map.get(sum);
                    if (i - prev >= 2) {
                        return true;
                    }
                } else {
                    map.put(sum, i);
                }

            } else {
                if (i > 0 && pref == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}