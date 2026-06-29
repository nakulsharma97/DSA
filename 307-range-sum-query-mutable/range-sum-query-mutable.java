class NumArray {
    int n ;
    int segment[] ;
    void buildTree(int i , int l , int r,int[] nums){
        if(l == r){
            segment[i] = nums[l] ;
            return ;
        }
        int mid = l + (r -l) / 2 ;
        buildTree(2*i +1 , l , mid , nums) ;
        buildTree(2 * i + 2 , mid +1 ,r , nums);
        segment[i] = segment[2*i+1] + segment[2*i+2] ;
    }
    void updateTree(int i , int l ,int r , int index , int val){
        if(l == r){
            segment[i] = val  ;
            return ;
        }
        int mid = l + (r - l) / 2 ;
        if( index <= mid ){
            updateTree(2*i +1 ,l ,mid , index , val) ;
        }
        else {
            updateTree(2*i+2 , mid +1 , r ,index, val) ;
        }
        segment[i] = segment[2*i +1] + segment[2*i+2] ;
    }
    public int  sumQuery(int i , int l ,int r , int left , int right){
       if(r < left  || l > right){
        return  0 ;
       }
       if(l >= left && right >= r){
        return segment[i] ;
       }
       int mid = l + (r -l) / 2 ;
       return sumQuery(2*i +1 , l ,mid ,left ,right) + sumQuery(2 * i+2 , mid +1 , r ,left, right) ;
    }

    public NumArray(int[] nums) {
        n = nums.length ;
        segment = new int[4*n] ;
        buildTree(0 ,0 , n-1 ,nums)  ;    
    }
    
    public void update(int index, int val) {
        updateTree(0 , 0 ,n-1 , index, val) ;
        
    }
    
    public int sumRange(int left, int right) {
       return sumQuery(0 , 0 , n-1 , left ,right)  ;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */