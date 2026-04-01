import java.util.*;

class Solution {

    public boolean isSame(char[] word, String str2, int i, int m) {
        for (int j = 0; j < m; j++) {
            if (word[i] != str2.charAt(j)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public String generateString(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();
        int N = n + m - 1;

        char[] word = new char[N];
        Arrays.fill(word, '$');

        boolean[] canChange = new boolean[N];

        // process T
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                if (i + m > N) return "";  // 🔥 FIX
                int i_ = i;
                for (int j = 0; j < m; j++) {
                    if (word[i_] != '$' && word[i_] != str2.charAt(j)) {
                        return "";
                    }
                    word[i_] = str2.charAt(j);
                    i_++;
                }
            }
        }

        // fill remaining with 'a'
        for (int i = 0; i < N; i++) {
            if (word[i] == '$') {
                word[i] = 'a';
                canChange[i] = true;
            }
        }

        // process F
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {


                if (isSame(word, str2, i, m)) {

                    boolean change = false;

                    for (int k = i + m - 1; k >= i; k--) {
                        if (canChange[k]) {
                            word[k] = 'b';
                            change = true;
                            break;
                        }
                    }

                    if (!change) return "";
                }
            }
        }

        return new String(word);
    }
}