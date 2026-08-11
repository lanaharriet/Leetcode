# Last updated: 8/11/2026, 9:02:35 AM
1class Solution:
2    def wordPattern(self, p: str, s: str) -> bool:
3        p = list(p)
4        s = s.split(' ')
5
6        if len(p) != len(s):
7            return False
8
9        h = {}
10
11        for i in range(len(p)):
12            if p[i] in h and s[i] != h[p[i]]:
13                return False
14
15            elif p[i] not in h and s[i] in h.values():
16                return False
17
18            else:
19                h[p[i]] = s[i]
20
21        return True