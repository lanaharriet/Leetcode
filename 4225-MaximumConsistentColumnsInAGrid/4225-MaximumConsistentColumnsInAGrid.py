# Last updated: 7/16/2026, 4:09:00 PM
class Solution:
    def maxConsistentColumns(self, grid: List[List[int]], limit: int) -> int:
        m, n = len(grid), len(grid[0])

        dp = [1] * n
        for j in range(1, n):
            for j_prev in range(j):
                is_valid = True
                for i in range(m):
                    if abs(grid[i][j] - grid[i][j_prev]) > limit:
                        is_valid = False
                        break
                if is_valid: dp[j] = max(dp[j], dp[j_prev] + 1)
                    
        return max(dp)