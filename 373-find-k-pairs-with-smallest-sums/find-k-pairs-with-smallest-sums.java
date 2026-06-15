import java.util.*;

class Solution {

    static class Pair {
        int sum;
        int i;
        int j;

        Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return result;
        }

        PriorityQueue<Pair> minHeap =
                new PriorityQueue<>((a, b) -> a.sum - b.sum);

        Set<String> visited = new HashSet<>();

        minHeap.offer(new Pair(nums1[0] + nums2[0], 0, 0));
        visited.add("0,0");

        while (k-- > 0 && !minHeap.isEmpty()) {

            Pair curr = minHeap.poll();

            int i = curr.i;
            int j = curr.j;

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // (i, j + 1)
            if (j + 1 < nums2.length &&
                !visited.contains(i + "," + (j + 1))) {

                minHeap.offer(
                    new Pair(nums1[i] + nums2[j + 1], i, j + 1)
                );

                visited.add(i + "," + (j + 1));
            }

            // (i + 1, j)
            if (i + 1 < nums1.length &&
                !visited.contains((i + 1) + "," + j)) {

                minHeap.offer(
                    new Pair(nums1[i + 1] + nums2[j], i + 1, j)
                );

                visited.add((i + 1) + "," + j);
            }
        }

        return result;
    }
}