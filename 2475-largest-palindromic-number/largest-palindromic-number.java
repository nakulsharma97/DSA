class Solution {
    public String largestPalindromic(String num) {
        int n = num.length();
        int freq[] = new int[10];
        StringBuilder sb = new StringBuilder();
        for (char ch : num.toCharArray()) {
            freq[ch - '0']++;
        }
        for(int i = 9 ; i  >= 0 ;i--){
            while(freq[i] >= 2){

                if (i == 0 && sb.length() == 0) {
                    break;
                }

                sb.append((char) (i + '0')) ;
                freq[i] -= 2 ;
            }
        }
        String middle = "" ;
        for(int i = 9 ; i >= 0 ; i--){
            if(freq[i] == 1){
                middle = String.valueOf((char) (i + '0')) ;
                break ;
            }
        }
       String right = new StringBuilder(sb).reverse().toString() ;
       if(sb.length() == 0 && middle.isEmpty()){
        return  "0" ;
       }
       return sb.toString() + middle + right ;

    }
}