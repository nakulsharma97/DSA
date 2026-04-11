class Solution {
    public int longestOnes(int[] nums, int k) {
        int right = 0, left = 0, maxl = 0;
        int zero = 0;
        int n = nums.length;
        while (right < n) {
            if (nums[right] == 0) {
                zero++;
            }
            if (zero > k) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            if(zero <= k){
                maxl = Math.max(maxl , right - left + 1) ;
            }
            right++ ;

        }
        return maxl;
    }
}