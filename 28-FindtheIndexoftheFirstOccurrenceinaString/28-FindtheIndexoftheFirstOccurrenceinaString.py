# Last updated: 8/6/2026, 9:11:22 AM
1class Solution:
2    def strStr(self, haystack, needle):
3        for i in range(len(haystack) - len(needle) + 1):
4            if haystack[i:i+len(needle)] == needle:
5                return i
6        return -1