class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int maxsum = nums[0];
        arr[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr[i] = Math.max(nums[i], arr[i - 1] + nums[i]);
            maxsum = Math.max(arr[i], maxsum);
        }

        int ar[] = new int[n];
        ar[0] = nums[0];
        int minsum = nums[0];
        int total = nums[0];
        for (int i = 1; i < n; i++) {
            total += nums[i];
            ar[i] = Math.min(nums[i], ar[i - 1] + nums[i]);
            minsum = Math.min(minsum, ar[i]);
        }
        if(maxsum < 0){
            return maxsum ;
        }
        int cir = total - minsum;
        return Math.max(cir, maxsum);
    }
}