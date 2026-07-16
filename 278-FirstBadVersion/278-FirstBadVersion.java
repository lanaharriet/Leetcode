// Last updated: 7/16/2026, 4:11:41 PM
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l=0,h=n;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(isBadVersion(mid)) h = mid-1;
            else l = mid+1;
        }
        return l;
    }
}