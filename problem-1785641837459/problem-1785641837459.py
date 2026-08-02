# Last updated: 8/2/2026, 9:07:17 AM
1from bisect import bisect_left, insort
2class Solution:
3    def countRatioSubarrays(self, nums: list[int], a: int, b: int) -> int:
4        n=len(nums)
5        ans=0
6        last_odd=-1
7
8        S=[0]*(n+1)
9        even,odd=0,0
10        for i in range(n):
11            if nums[i] % 2==0:
12                even+=1
13            else:
14                odd+=1
15            S[i+1]=even * b - odd*a
16
17        active_prefixes=[]
18        last_added=-1
19
20        for j in range(n):
21            if nums[j] %2!=0:
22                last_odd=j
23
24            if last_odd!=-1:
25                while last_added <last_odd:
26                    insort(active_prefixes, S[last_added +1])
27                    last_added+=1
28
29                target=S[j+1]
30                idx=bisect_left(active_prefixes,target)
31                ans+=len(active_prefixes)-idx
32
33        return ans
34        