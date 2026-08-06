# Last updated: 8/6/2026, 9:12:37 AM
1class Solution:
2  def addBinary(self, a: str, b: str) -> str:
3    s = []
4    carry = 0
5    i = len(a) - 1
6    j = len(b) - 1
7
8    while i >= 0 or j >= 0 or carry:
9      if i >= 0:
10        carry += int(a[i])
11        i -= 1
12      if j >= 0:
13        carry += int(b[j])
14        j -= 1
15      s.append(str(carry % 2))
16      carry //= 2
17
18    return ''.join(reversed(s))