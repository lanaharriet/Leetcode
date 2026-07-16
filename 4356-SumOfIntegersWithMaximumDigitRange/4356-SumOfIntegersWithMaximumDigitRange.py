# Last updated: 7/16/2026, 4:08:49 PM
class Solution(object):
    def maxDigitRange(self, nums):
        mx=-1
        ans=0

        for num in nums:
            x=num
            mn=9
            md=0

            while x:
                d=x%10
                if d<mn:
                    mn=d
                if d>md:
                    md=d
                x//=10

            r=md-mn

            if r>mx:
                mx=r
                ans=num
            elif r==mx:
                ans+=num

        return ans
        