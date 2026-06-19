class Solution {
    public int largestAltitude(int[] gain) {
     int maxx = Integer.MAX_VALUE ;
     int n = gain.length ;
     int arr[] = new  int[n+1];
     arr[0] = 0 ;
    for(int i = 1 ; i <= n ;i++){
        arr[i] = arr[i-1] + gain[i - 1] ;
    }
     Arrays.sort(arr) ;
     return arr[n] ;
    }
}