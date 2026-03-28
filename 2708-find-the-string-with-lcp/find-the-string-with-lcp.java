class Solution {
    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char[] word = new char[n];

        // Fill placeholder
        for (int i = 0; i < n; i++) {
            word[i] = '$';
        }

        // Step 1: Construct string
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (lcp[j][i] != 0) {
                    word[i] = word[j];
                    break;
                }
            }

            if (word[i] == '$') {
                boolean[] forb = new boolean[26];

                for (int j = 0; j < i; j++) {
                    if (lcp[j][i] == 0) {
                        forb[word[j] - 'a'] = true;
                    }
                }

                for (int idx = 0; idx < 26; idx++) {
                    if (!forb[idx]) {
                        word[i] = (char) (idx + 'a');
                        break;
                    }
                }

                if (word[i] == '$') return "";
            }
        }

        // Step 2: VALIDATE LCP
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int expected = lcp[i][j];
                int actual = 0;

                int x = i, y = j;
                while (x < n && y < n && word[x] == word[y]) {
                    actual++;
                    x++;
                    y++;
                }

                if (actual != expected) {
                    return "";
                }
            }
        }

        return new String(word);
    }
}