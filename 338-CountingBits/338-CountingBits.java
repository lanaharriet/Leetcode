// Last updated: 8/6/2026, 10:02:30 AM
1class Solution {
2    public int[] countBits(int n) {
3        int[] dp = new int[n + 1];
4        int sub = 1;
5
6        for (int i = 1; i <= n; i++) {
7            if (sub * 2 == i) {
8                sub = i;
9            }
10
11            dp[i] = dp[i - sub] + 1;
12        }
13
14        return dp;        
15    }
16}