// Last updated: 7/16/2026, 4:11:30 PM
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0)
        return false;
        if(n==1)
        return true;
        while(n%4==0)
          n=n/4;
          if(n==1)
            return true;
          else
            return false;
    }
}