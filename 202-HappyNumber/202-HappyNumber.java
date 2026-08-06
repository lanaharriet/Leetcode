// Last updated: 8/6/2026, 9:30:00 AM
1class Solution {
2    public boolean isHappy(int n) {
3        int slow = n, fast = n;
4        do {
5            slow = sumOfSquares(slow);
6            fast = sumOfSquares(sumOfSquares(fast));
7        } while (slow != fast);
8        return slow == 1;
9    }
10    private int sumOfSquares(int n) {
11        int squareSum = 0;
12        while (n > 0) {
13            int r = n % 10;
14            n = n / 10;
15            squareSum += r * r;
16        }
17        return squareSum;
18    }
19}