class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length;
        int m = nums2.length;

        int low = 0, high = n;

        while (low <= high) {

            int cut1 = (low + high) / 2;
            int cut2 = (n + m + 1) / 2 - cut1;

            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int R1 = (cut1 == n) ? Integer.MAX_VALUE : nums1[cut1];

            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int R2 = (cut2 == m) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 <= R2 && L2 <= R1) {

                if ((n + m) % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.max(L1, L2);
                }

            } else if (L1 > R2) {
                high = cut1 - 1;
            } else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}