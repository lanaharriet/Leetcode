# Last updated: 7/19/2026, 8:29:34 AM
1class Solution(object):
2    def canReach(self, start, target):
3        return(start[0] + start[1]) % 2==(target[0]+target[1])%2
4        