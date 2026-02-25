import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        // Convert int[] to Integer[]
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        // Sort using custom logic
        Arrays.sort(nums, (a, b) -> {
            int bitsA = Integer.bitCount(a);
            int bitsB = Integer.bitCount(b);

            if (bitsA != bitsB) {
                return bitsA - bitsB;   // sort by number of 1s
            }

            return a - b;              // if equal bits, sort by value
        });

        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}