// Last updated: 7/16/2026, 4:13:44 PM
class Solution {
    public boolean isPalindrome(int x) {
        int rev = 0, temp = x;

        while (temp > 0) {
            rev = rev * 10 + temp % 10;
            temp = temp / 10;
        }

        return x == rev;
    }
}