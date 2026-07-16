// Last updated: 7/16/2026, 4:11:09 PM
class Solution {
    public int findComplement(int num) {
        int n =0;
        while(n<num){
            n= (n<<1)|1;
        }
        return n-num; 
    }
}