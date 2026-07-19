# Last updated: 7/19/2026, 9:07:23 AM
1class Solution(object):
2    def transformStr(self, s, strs):
3        n=len(s)
4        k=s.count('1')
5
6        pref_s =[0]*n
7        curr=0
8        for i in range(n):
9            if s[i]=='1':
10                curr+=1
11            pref_s[i]=curr
12
13        ans=[]
14        for t in strs:
15            fixed_ones=t.count('1')
16            q_count=t.count('?')
17
18            if fixed_ones>k or fixed_ones +q_count<k:
19                ans.append(False)
20                continue
21
22            needed_ones=k-fixed_ones
23
24            q_seen=0
25            possible=True
26            pref_t_curr=0
27
28            for i in range(n):
29                char=t[i]
30                if char=='?':
31                    q_seen+=1
32
33                    if q_count - q_seen<needed_ones:
34                        pref_t_curr+=1
35                elif char=='1':
36                    pref_t_curr+=1
37
38                if pref_t_curr>pref_s[i]:
39                    possible=False
40                    break
41
42            ans.append(possible)
43        return ans