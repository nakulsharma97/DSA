import java.util.*;

class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        char[] even1 = new char[(n + 1) / 2];
        char[] odd1 = new char[n / 2];
        char[] even2 = new char[(n + 1) / 2];
        char[] odd2 = new char[n / 2];

        int e1 = 0, o1 = 0, e2 = 0, o2 = 0;

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                even1[e1++] = s1.charAt(i);
                even2[e2++] = s2.charAt(i);
            } else {
                odd1[o1++] = s1.charAt(i);
                odd2[o2++] = s2.charAt(i);
            }
        }

        Arrays.sort(even1);
        Arrays.sort(even2);
        Arrays.sort(odd1);
        Arrays.sort(odd2);

        return Arrays.equals(even1, even2) && Arrays.equals(odd1, odd2);
    }
}