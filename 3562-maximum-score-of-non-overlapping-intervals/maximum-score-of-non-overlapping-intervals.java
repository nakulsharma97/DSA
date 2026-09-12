import java.util.*;

class Solution {

    class Interval {
        int l, r, w, idx;

        Interval(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    class Node {
        long score;
        int[] indices;

        Node(long score, int[] indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    Node[][] dp;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        arr = new Interval[n];

        // Store original indices
        for (int i = 0; i < n; i++) {

            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by start, then end
        Arrays.sort(arr, (a, b) -> {

            if (a.l != b.l) {
                return Integer.compare(a.l, b.l);
            }

            return Integer.compare(a.r, b.r);
        });

        dp = new Node[n + 1][5];

        Node ans = solve(0, 4);

        return ans.indices;
    }

    Node solve(int i, int k) {

        if (i == n || k == 0) {
            return new Node(0, new int[0]);
        }

        if (dp[i][k] != null) {
            return dp[i][k];
        }

        // Skip
        Node skip = solve(i + 1, k);

        // Take
        int next = findNext(i);

        Node nextNode = solve(next, k - 1);

        int[] takeIndices =
            new int[nextNode.indices.length + 1];

        takeIndices[0] = arr[i].idx;

        for (int j = 0; j < nextNode.indices.length; j++) {

            takeIndices[j + 1] = nextNode.indices[j];
        }

        Arrays.sort(takeIndices);

        Node take = new Node(
            arr[i].w + nextNode.score,
            takeIndices
        );

        dp[i][k] = better(take, skip);

        return dp[i][k];
    }

    int findNext(int i) {

        int low = i + 1;
        int high = n - 1;

        int ans = n;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].l > arr[i].r) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    Node better(Node a, Node b) {

        if (a.score != b.score) {

            return a.score > b.score ? a : b;
        }

        return compare(a.indices, b.indices) < 0 ? a : b;
    }

    int compare(int[] a, int[] b) {

        int m = Math.min(a.length, b.length);

        for (int i = 0; i < m; i++) {

            if (a[i] != b[i]) {

                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }
}