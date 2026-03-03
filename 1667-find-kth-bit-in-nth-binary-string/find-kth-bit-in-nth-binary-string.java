class Solution {
    public char findKthBit(int n, int k) {
        int len = (int) Math.pow(2, n) - 1;
        return recu(len, k);
    }

    public char recu(int len , int k){
        if(len == 1) return '0' ; 
        int half = len / 2 ;
        int middle = len / 2 + 1 ;
        if(middle == k) return '1' ;
        else if(k < middle){ // left  
  return recu(half , k) ;
        }
        else {
            char ans = recu(half , len - k + 1) ;
            return (ans ==  '1') ? '0' : '1' ;
        }
    }
}