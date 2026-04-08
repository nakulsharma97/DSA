class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0;      // read pointer
        int index = 0;  // write pointer

        while (i < n) {
            char current = chars[i];
            int count = 0;

            // count frequency
            while (i < n && chars[i] == current) {
                i++;
                count++;
            }

            // write character
            chars[index++] = current;

            // write count if >1
            if (count > 1) {
                String cnt = String.valueOf(count);
                for (char c : cnt.toCharArray()) {
                    chars[index++] = c;
                }
            }
        }

        return index;
    }
}