import java.util.*;

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Step 1: store indices of each number
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        List<Integer> ans = new ArrayList<>();

        // Step 2: process queries
        for (int q : queries) {
            List<Integer> v = map.get(nums[q]);

            // if only one occurrence
            if (v.size() == 1) {
                ans.add(-1);
                continue;
            }

            // binary search to find position of q
            int pos = Collections.binarySearch(v, q);

            int res = Integer.MAX_VALUE;

            // left neighbor (circular)
            int left = v.get((pos - 1 + v.size()) % v.size());
            int d1 = Math.abs(q - left);
            res = Math.min(res, Math.min(d1, n - d1));

            // right neighbor (circular)
            int right = v.get((pos + 1) % v.size());
            int d2 = Math.abs(q - right);
            res = Math.min(res, Math.min(d2, n - d2));

            ans.add(res);
        }

        return ans;
    }
}