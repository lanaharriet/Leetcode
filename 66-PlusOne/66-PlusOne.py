# Last updated: 8/6/2026, 9:09:43 AM
1class Solution:
2    def plusOne(self, digits: List[int]) -> List[int]:
3
4        for i in range(len(digits) - 1, -1, -1):
5
6            if digits[i] + 1 != 10:
7                digits[i] += 1
8                return digits
9            
10            digits[i] = 0
11
12            if i == 0:
13                return [1] + digits