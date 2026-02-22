class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;

        Set<Integer> primes = new HashSet<>(Arrays.asList(
            2, 3, 5, 7, 11, 13, 17, 19
        ));

        for (int i = left; i <= right; i++) {
            int bitcount = Integer.bitCount(i);  
            if (primes.contains(bitcount)) {
                ans++;
            }
        }

        return ans;
    }
}