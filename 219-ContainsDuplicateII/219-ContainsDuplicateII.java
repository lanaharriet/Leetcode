// Last updated: 8/11/2026, 9:01:37 AM
1class Solution {
2    public boolean isUgly(int n) {
3        if (n <= 0) {
4            return false;
5        }
6        int[] factors = {2, 3, 5};
7        for (int factor : factors) {
8            while (n % factor == 0) {
9                n /= factor;
10            }
11        }
12        return n == 1;
13    }
14}