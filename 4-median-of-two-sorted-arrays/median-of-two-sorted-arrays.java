import java.util.Arrays;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double med = 0;
int i = 0 ;
int j = 0 ;
int k = 0 ;

        int n = nums1.length ;
        int n1 = nums2.length ;
        int [] result = new int[n + n1] ;
        while(i < n && j < n1 ){
            if(nums1[i] > nums2[j]){
                result[k] = nums2[j] ;
                j++ ;
            }
            else {
                result[k] = nums1[i] ;
                i++ ;
            }
            k++ ;

        }
while (i < n){
    result[k] = nums1[i] ;
    i++ ;
    k++;
}
while( j < n1){
    result[k] = nums2[j] ;
    j++;
    k++ ;
}
if(k % 2 != 0){
    return result[k / 2] ;
} 
 
    return ( result[ (k -1) / 2]  + result[k / 2] ) / 2.0;
 
    }
}