// Last updated: 8/6/2026, 9:18:28 AM
1class Solution {
2    public int singleNumber(int[] nums) {
3        int result=0;
4        for(int x:nums){
5            result^=x;
6        }
7        return result;
8    }
9}