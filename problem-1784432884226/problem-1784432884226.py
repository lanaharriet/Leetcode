# Last updated: 7/19/2026, 9:18:04 AM
1class Solution(object):
2    def minimumGroups(self, words):
3        def get_min_rotation(s):
4            n=len(s)
5            s2=s+s
6            f=[-1]*(2*n)
7            k=0
8            for j in range(1,2*n):
9                sj=s2[j]
10                i=f[j-k-1]
11                while i!=-1 and sj!=s2[k+i+1]:
12                    if sj<s2[k+i+1]:
13                        k=j-i-1
14                    i=f[i]
15
16                if sj!=s2[k+i+1]:
17                    if sj<s2[k]:
18                        k=j
19                    f[j-k]=-1
20
21                else:
22                    f[j-k]=i+1
23            return s2[k:k+n]
24
25        unique_groups=set()
26
27        for w in words:
28            even_sub=w[0::2]
29            odd_sub=w[1::2]
30
31            canonical_even=get_min_rotation(even_sub)
32            canonical_odd=get_min_rotation(odd_sub)
33
34            unique_groups.add((canonical_even, canonical_odd))
35
36        return len(unique_groups)
37
38                
39        