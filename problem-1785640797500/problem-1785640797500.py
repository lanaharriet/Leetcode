# Last updated: 8/2/2026, 8:49:57 AM
1class Solution:
2    def countRatioSubarrays(self, nums: list[int], a: int, b: int) -> int:
3        valid_count=0
4        n=len(nums)
5
6        for i in range(n):
7            even_count=0
8            odd_count=0
9            for j in range(i,n):
10                if nums[j]%2==0:
11                    even_count+=1
12                else:
13                    odd_count+=1
14
15                if odd_count>0:
16                    if even_count * b <= a* odd_count:
17                        valid_count+=1
18
19        return valid_count
20        