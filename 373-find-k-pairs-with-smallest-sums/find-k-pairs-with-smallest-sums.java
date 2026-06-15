import java.util.*;

class Solution {

    static class Pair {
        int i;
        int j;
        int sum;

        Pair(int i, int j, int sum) {
            this.i = i;
            this.j = j;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Pair> minHeap =
                new PriorityQueue<>((a, b) -> a.sum - b.sum);

        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }

        while (k-- > 0 && !minHeap.isEmpty()) {

            Pair curr = minHeap.poll();

            int i = curr.i;
            int j = curr.j;

            result.add(Arrays.asList(nums1[i], nums2[j]));

            if (j + 1 < nums2.length) {
                minHeap.offer(
                    new Pair(i, j + 1, nums1[i] + nums2[j + 1])
                );
            }
        }

        return result;
    }
}