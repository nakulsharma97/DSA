class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;
        int n = encodedText.length();
        int cols = n / rows;
        StringBuilder res = new StringBuilder(n);
        for (int i = 0; i < cols; i++) {
            int r = 0, j = i;
            while (r < rows && j < cols) {
                res.append(encodedText.charAt(r * cols + j));
                r++;
                j++;

            }
        }
        int end = res.length()-1 ;
        while( end >= 0 && res.charAt(end) == ' '){
            end-- ;
        }
        return res.substring( 0 , end+1 ) ;
    }
}