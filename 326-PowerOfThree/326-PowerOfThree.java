// Last updated: 7/16/2026, 4:11:32 PM
class Solution {
    public boolean isPowerOfThree(int n) {
        if(n<1)
        return false;
        if(n==1)
        return true;
        while(n%3==0)
        n=n/3;
        if(n==1)
        return true;
        else
        return false;
        
    }
}