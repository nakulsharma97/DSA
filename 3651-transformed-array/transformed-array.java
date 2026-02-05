class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int shift = nums[i] % n;
            int newind = (i + shift ) % n;
            if (newind < 0) {
                newind = newind + n;
            }
            res[i] = nums[newind];
            // res[i] = nums[(((i +  nums[i]) % n ) + n ) % n] ;

        }
        return res;
    }
}