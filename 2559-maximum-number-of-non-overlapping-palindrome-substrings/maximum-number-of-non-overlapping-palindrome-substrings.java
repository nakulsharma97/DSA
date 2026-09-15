class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int ans = 0;
        int left = 0;
        while (left <= n - k) {
            if (isPalindrome(s, left, left + k - 1)) {
                ans++;
                left += k;              // yahi "right" jump hai
            }
            else if (left <= n - k - 1 && isPalindrome(s, left, left + k)) {
                ans++;
                left += k + 1;
            }
            else {
                left++;
            }
        }
        return ans;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}