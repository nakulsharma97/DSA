class Solution {
    public int numSteps(String s) {
        int steps = 0 , carry = 0 ;
        for(int i = s.length() -1 ; i > 0  ;i--){
            if((s.charAt(i) & 1) + carry == 1){ // the number is odd 
                steps = steps + 2 ; // number & 1 + carry = 1 = odd 
                carry = 1 ;
            }
            else {
                steps = steps+1 ; // the  number is even 
            }
            // odd number ka last bit always 1 
            // vice versa in even case 
        } 
        return steps + carry ;
    
}
}