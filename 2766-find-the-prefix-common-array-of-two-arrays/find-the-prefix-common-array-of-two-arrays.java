class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int res[] = new int[n];
         HashSet<Integer> set = new HashSet<>();
        if (A[0] != B[0]) {
            res[0] = 0;
            set.add(A[0]) ;
            set.add(B[0]);
        }
        if (A[0] == B[0]) {
            res[0] = 1;
        }
       
        for (int i = 1; i < n; i++) {
            if (A[i] == B[i]) {
                res[i] = res[i - 1] + 1;
            } 
            else if (A[i] != B[i]) {
                int a = 0;
                if (set.contains(A[i])) {
                    a++;
                } 
                if (set.contains(B[i])) {
                    a++;                                        
                }
                 if (!set.contains(A[i])) {
                    set.add(A[i]);
                } if (!set.contains(B[i])) {
                    set.add(B[i]);
                }
                 
                res[i] = res[i - 1] + a;

            }

        }return res;
}}