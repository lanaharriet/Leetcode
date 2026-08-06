// Last updated: 8/6/2026, 9:39:45 AM
1class Solution {
2    public char findTheDifference(String s, String t) {
3        char c = 0;
4        for(char cs : s.toCharArray()) c ^= cs;
5        for(char ct : t.toCharArray()) c ^= ct;
6        return c;
7    }
8}