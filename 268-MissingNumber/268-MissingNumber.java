// Last updated: 7/16/2026, 4:11:42 PM
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        int actual = 0;

        // for (int i = 0; i<nums.length; i++) {
        //     actual = actual + nums[i];
        // }
        for (int x : nums) {
            actual += x;
        }

        return expected - actual;
    }
}