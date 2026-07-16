// Last updated: 7/16/2026, 4:10:26 PM
class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n^(n>>1);
        return(x&(x+1))==0;
        
    }
}