class Solution {
    public String reverseVowels(String s) {
        char[] chArr = s.toCharArray();
        Set<Character> hset = new HashSet<>(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));

        int i=0, j=chArr.length-1;

        while(i<j){
            if(hset.contains(chArr[i])){
                while(j>=i){
                    if(hset.contains(chArr[j])){
                        char temp = chArr[i];
                        chArr[i] = chArr[j];
                        chArr[j] = temp;
                        j--;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }

        return new String(chArr);
    }
}