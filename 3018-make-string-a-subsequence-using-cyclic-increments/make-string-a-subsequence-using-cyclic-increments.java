class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int targetind = 0 , targetlen = str2.length() ;
        for(char ch : str1.toCharArray()){
            if(targetind <  targetlen && (str2.charAt(targetind) - ch + 26) % 26 <=1 ){
                targetind++ ;
            }
        }
        return targetind == targetlen ;

    }
}