# Last updated: 7/20/2026, 11:08:25 AM
class Solution(object):
    def canReach(self, start, target):
        return(start[0] + start[1]) % 2==(target[0]+target[1])%2
        