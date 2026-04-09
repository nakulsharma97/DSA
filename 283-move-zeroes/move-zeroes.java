class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                continue;
            } else {
                for (int j = i; j < n; j++) {
                    if (nums[j] != 0) {
                        int s = nums[j];
                        nums[i] = s;
                        nums[j] = temp;
                        break ;
                    }
                }

            }
        }
    }
}