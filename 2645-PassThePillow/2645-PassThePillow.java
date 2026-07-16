// Last updated: 7/16/2026, 4:09:15 PM
class Solution {
    public int passThePillow(int n, int time) {
        int pos=1;
        int dir=1;
        for(int i=0;i<time;i++){
            pos+=dir;
            if(pos==n||pos==1) dir=-dir;
        }
        return pos;
    }
}