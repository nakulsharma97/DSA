class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zero = 0, right = 0;
        int left = 0;
        int maxl = 0;
        while (right < n) {
            if (nums[right] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            maxl = Math.max(maxl, right - left );
            right++ ;

        }
        return maxl ;
    }
}