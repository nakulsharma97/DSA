class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (map.containsKey(val)) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }
}