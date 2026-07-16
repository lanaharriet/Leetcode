# Last updated: 7/16/2026, 4:08:51 PM
class Solution(object):
    def minimumCost(self, nums, k):
        MOD=10**9+7
        resources=k
        operations=0
        cost=0

        for x in nums:
            if resources<x:
                need=x-resources
                extra=(need+k-1)//k

                cost=(cost+(operations+1+operations+extra)*extra//2)%MOD
                operations+=extra
                resources+=extra*k

            resources-=x

        return cost%MOD
                
        
        
        