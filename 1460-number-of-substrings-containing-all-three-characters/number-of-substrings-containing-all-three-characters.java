class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int a = 0, b = 0, c = 0;
        int l = 0;
        int ans = 0;

        for (int r = 0; r < n; r++) {

            if (s.charAt(r) == 'a') a++;
            else if (s.charAt(r) == 'b') b++;
            else c++;

            while (a > 0 && b > 0 && c > 0) {

                ans += (n - r);

                if (s.charAt(l) == 'a') a--;
                else if (s.charAt(l) == 'b') b--;
                else c--;

                l++;
            }
        }

        return ans;
    }
}