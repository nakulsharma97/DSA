import java.util.*;

class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        long ans = Long.MAX_VALUE;
        long currsum = 0;

        // TreeSet storing indices, ordered by nums[index]
        TreeSet<Integer> set = new TreeSet<>(
            (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );
        TreeSet<Integer> waiting = new TreeSet<>(
            (a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]
        );

        k = k - 1; // nums[0] is always taken
        int last = Math.min(dist + 1, n - 1);

        // Initial window
        for (int i = 1; i <= last; i++) {
            currsum += nums[i];
            set.add(i);
        }

        // Keep only k smallest
        while (set.size() > k) {
            int ind = set.pollLast();   // ❗ remove largest
            currsum -= nums[ind];
            waiting.add(ind);
        }

        ans = currsum;

        // Sliding window
        for (int r = dist + 2, l = 1; r < n; r++, l++) {

            waiting.add(r);

            if (set.contains(l)) {
                set.remove(l);
                currsum -= nums[l];

                int smallest = waiting.pollFirst();
                set.add(smallest);
                currsum += nums[smallest];
            } else {
                waiting.remove(l);
            }

            // Rebalance if needed
            if (!set.isEmpty() && !waiting.isEmpty()
                    && nums[set.last()] > nums[waiting.first()]) {

                int big = set.pollLast();
                currsum -= nums[big];
                waiting.add(big);

                int small = waiting.pollFirst();
                set.add(small);
                currsum += nums[small];
            }

            ans = Math.min(ans, currsum);
        }

        return nums[0] + ans;
    }
}
