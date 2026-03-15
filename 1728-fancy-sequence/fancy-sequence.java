class Fancy {
    long MOD = 1000000007;
    ArrayList<Long> seq;
    long add = 0 ;
    long mult = 1 ;

    // binanry exponentiation for fermat little theorem 
 long power( long a , long b ){
        if(b== 0)
        return 1 ;

         long half = power(a , b/2) ;
         long result = (half * half) % MOD ;
        if(b % 2 == 1){
            result = (result * a) % MOD ;
        }
        return result ;
    }

    public Fancy() {
        seq = new ArrayList<>();
    }
    
    public void append(int val) {
         long x = ((val - add) % MOD + MOD) * power( mult , MOD - 2) % MOD ;
        seq.add(x) ;
    }
    
    public void addAll(int inc) {
        add = (add + inc) % MOD ;
    }
    
    public void multAll(int m) {
        add = (add * m) % MOD ;
        mult = ( mult * m ) % MOD ;
    }
    
    public int getIndex(int idx) {
        if(idx >=seq.size()) 
        return -1 ;

        return (int)((seq.get(idx) * mult + add) % MOD) ;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */