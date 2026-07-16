// Last updated: 7/16/2026, 4:09:32 PM
class Solution {
    public int subtractProductAndSum(int n) {
        int prod = 1, sum = 0;

        while (n > 0) {
            int digit = n % 10;
            prod *= digit;
            sum += digit;
            n /= 10;
        }

        return prod - sum;
    }
}