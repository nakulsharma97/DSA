class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        int n = nums.length;
        int right = 0;
        int left = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;

        while (right < n) {

            int a = nums[right];

            map.put(a, map.getOrDefault(a, 0) + 1);

            while (map.get(a) > k) {
                int b = nums[left];

                map.put(b, map.get(b) - 1);

                left++;
            }

            max = Math.max(max, right - left + 1);

            right++;
        }

        return max;
    }
}