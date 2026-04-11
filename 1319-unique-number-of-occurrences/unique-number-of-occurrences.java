class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer ,Integer> map =new HashMap<>() ;
        for(int i = 0 ; i < arr.length ;i++){
            map.put(arr[i] , map.getOrDefault(arr[i] , 0) + 1) ;
        }
        Set<Integer> s1 = new HashSet<>() ;
        for(int i : map.values()){
            if(s1.contains(i)){
                return false ;
            }
            s1.add(i) ;
        }
        return true ;
    }
}