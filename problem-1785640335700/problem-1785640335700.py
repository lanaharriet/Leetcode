# Last updated: 8/2/2026, 8:42:15 AM
1class Solution(object):
2    def maxPairStrength(self, nums):
3        def get_gcd(a,b):
4            while b:
5                a,b=b,a%b
6            return a
7
8        max_strength=0
9        n=len(nums)
10        for i in range(n):
11            for j in range(i+1,n):
12                g=get_gcd(nums[i],nums[j])
13                strength=(nums[i] * nums[j]) // (g*g)
14                if strength > max_strength:
15                    max_strength = strength
16        return max_strength