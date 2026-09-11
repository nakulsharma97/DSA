class Solution {
    public int totalNumbers(int[] digits) {
        int n = digits.length ;
        List<Integer> arr = new ArrayList<>() ;
        for(int i = 0 ; i < n ;i++){
            if(digits[i] == 0){
                continue ;
            }
            for(int j = 0 ; j < n ;j++){
                if(j == i){
                    continue ;
                }
                for(int k = 0 ; k < n ;k++){
                    if(i == k || j == k){
                        continue ;
                    }
                    if(digits[k] % 2 != 0){
                        continue ; 
                    }
                    int a = digits[i] * 100 + digits[j]* 10 + digits[k] ;
                    if(arr.contains(a)){
                        continue;
                    }
                    arr.add(a) ;
                }
            }
        }
        Collections.sort(arr) ;
        return arr.size() ;
    }
}