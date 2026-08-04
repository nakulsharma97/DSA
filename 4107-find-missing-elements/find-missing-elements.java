class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {

            int num = nums[i];

            while (num + 1 < nums[i + 1]) {
                list.add(num + 1);
                num++;
            }
        }

        return list;
    }
}