// Last updated: 7/16/2026, 4:10:05 PM
class Solution {
    public int fib(int n) {
        int a = 0, b = 1;

        for (int i = 0; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a;
    }
}