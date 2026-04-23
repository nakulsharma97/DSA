class Solution {
    public long[] distance(int[] nums) {

        int n = nums.length;
        long[] result = new long[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        for (List<Integer> indices : map.values()) {

            int size = indices.size();

            long totalIndexSum = 0;
            for (int index : indices) {
                totalIndexSum += index;
            }

            long leftIndexSum = 0; 

            for (int i = 0; i < size; i++) {

                int currentIndex = indices.get(i);

                long rightIndexSum = totalIndexSum - leftIndexSum - currentIndex;
                
                long leftDistance = (long) currentIndex * i - leftIndexSum ;

                long rightDistance = rightIndexSum - (long) currentIndex *  ( size - i - 1) ;
                // Total distance
                result[currentIndex] = leftDistance + rightDistance;

                // Add current index to left sum for next iteration
                leftIndexSum += currentIndex;
            }
        }

        return result;
    }
}