// Last updated: 8/6/2026, 9:21:44 AM
1class Solution {
2    public int majorityElement(int[] nums) {
3
4        int n = nums.length;
5
6        for(int i = 0; i < n; i++){
7
8            int count = 0;
9
10            for(int j = 0; j < n; j++){
11
12                if(nums[i] == nums[j]){
13                    count++;
14                }
15            }
16
17            if(count > n / 2){
18                return nums[i];
19            }
20        }
21
22        return -1;
23    }
24}