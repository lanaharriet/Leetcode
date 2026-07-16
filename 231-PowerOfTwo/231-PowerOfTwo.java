// Last updated: 7/16/2026, 4:11:55 PM
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<=0)
           return false;
        if(n==1)
           return true;
        while(n%2==0)
        n=n/2;
        if(n==1)
        return true;  
        else
        return false;   
    }
}