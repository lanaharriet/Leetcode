// Last updated: 7/16/2026, 4:09:26 PM
class Solution {
    public int[] runningSum(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            nums[i]=sum;
        }
    return nums;  
    }
}