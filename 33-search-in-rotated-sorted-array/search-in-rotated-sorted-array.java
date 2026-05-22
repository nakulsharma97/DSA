class Solution {
    public int  pivot(int [] arr){
        int n = arr.length ;
        int left = 0 ;
        int right = n-1 ;
        int mid = 0 ;
        while(left < right){
             mid = left + (right - left) / 2 ;
            if(arr[mid] > arr[right]){
                left = mid + 1 ;
            }
            else {
                right = mid ;
            }
            
        }
        return left ;
    }
    public int search(int[] nums, int target) {
        int n = nums.length ;
        int pivott = pivot(nums) ;
        int left  = 0 ;
        int right = pivott -1 ;
        while(left <= right){
            int mid = left + (right - left)  / 2 ;
            if(nums[mid] == target){
                return mid ;
            }
            if(nums[mid] > target){
                right = mid -1  ;
            }
            else{
                left = mid + 1 ;
            }
        }
        int r = n -1 ;
        while( pivott <= r){
            int m = pivott + (r - pivott) / 2 ;
            if(nums[m] == target){
                return m ;
            }
            if(nums[m] > target){
                r = m -  1 ;
            }
            else {
                pivott = m + 1;
            }

        }
        return -1 ;

    }
}