# Last updated: 8/2/2026, 8:55:16 AM
1from bisect import bisect_right
2from typing import List
3
4class Solution:
5    def countTasks(self, tasks: List[int], shifts: List[int]) -> List[int]:
6        n=len(tasks)
7        pref=[0]*(n+1)
8        for i in range(n):
9            pref[i+1] = pref[i] + tasks[i]
10
11        ans=[]
12        current_time_offset=0
13
14        for shift in shifts:
15            current_time_offset+=shift
16            idx=bisect_right(pref,current_time_offset)-1
17
18            if idx>=n:
19                ans.append(0)
20                current_time_offset=0
21            else:
22                ans.append(n-idx)
23
24        return ans