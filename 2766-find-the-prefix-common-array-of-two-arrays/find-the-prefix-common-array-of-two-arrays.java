import java.util.*;

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length;
        int[] res = new int[n];

        HashSet<Integer> seenA = new HashSet<>();
        HashSet<Integer> seenB = new HashSet<>();

        int common = 0;

        for (int i = 0; i < n; i++) {

            if (seenB.contains(A[i])) {
                common++;
            }

            if (seenA.contains(B[i])) {
                common++;
            }

            if (A[i] == B[i]) {
                common++;
            }

            seenA.add(A[i]);
            seenB.add(B[i]);

            res[i] = common;
        }

        return res;
    }
}