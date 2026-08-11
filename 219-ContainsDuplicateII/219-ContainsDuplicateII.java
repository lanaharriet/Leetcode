// Last updated: 8/11/2026, 9:21:40 AM
1class Solution {
2    public List<String> readBinaryWatch(int turnedOn) {
3        List<String> result = new ArrayList<>();
4        for (int h = 0; h < 12; h++) {
5            for (int m = 0; m < 60; m++) {
6                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
7                    result.add(String.format("%d:%02d", h, m));
8                }
9            }
10        }
11        return result;
12    }
13}