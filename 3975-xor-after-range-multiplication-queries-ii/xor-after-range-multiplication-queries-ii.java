class Solution {
    private static final int mod = 1000000007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int t = (int)Math.sqrt(n);
        List<List<int[]>> groups = new ArrayList<>(t);
        for(int i=0;i<t;i++){
            groups.add(new ArrayList<>());
        }
        for(int[] q:queries){
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if(k<t){
                groups.get(k).add(new int[]{l,r,v});
            }
            else{
                for(int i=l;i<=r;i+=k){
                    nums[i] = (int)(((long)nums[i]*v)%mod);
                }
            }
        }
        long[] dif = new long[n+t];
        for(int k=1;k<t;k++){
            if(groups.get(k).isEmpty()){
                continue;
            }
            Arrays.fill(dif,1);
            for(int[] q:groups.get(k)){
                int l = q[0], r = q[1], v = q[2];
                dif[l] = (dif[l] * v) % mod;
                int R = ((r-l)/k+1)*k+l;
                dif[R] = (dif[R] * pow(v,mod-2))% mod;
            }
            for(int i=k;i<n;i++){
                dif[i] = (dif[i] * dif[i-k])% mod;
            }
            for(int i=0;i<n;i++){
                nums[i] = (int)(((long)nums[i]*dif[i])% mod);
            }
        }
        int res = 0;
        for(int x:nums){
            res ^= x;
        }
        return res;
    }
    private int pow(long x,long y){
        long res = 1;
        while(y>0){
            if((y&1)==1){
                res = (res*x) % mod;
            }
            x = (x*x)%mod;
            y >>= 1;
        }
        return (int)res;
    }
}