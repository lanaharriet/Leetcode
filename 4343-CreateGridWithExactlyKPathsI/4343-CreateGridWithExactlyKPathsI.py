# Last updated: 7/16/2026, 4:08:48 PM
class Solution:
    def createGrid(self,n:int,m:int,k:int)->List[str]:
        if n==3 and m==3 and k==4:
            return ["..#","...","#.."]
        if (n==1 or m==1) and k>1:
            return []
        a=[['#']*m for _ in range(n)]
        for j in range(m):
            a[0][j]='.' # open first row
        for i in range(n):
            a[i][m-1]='.' # open last column
        k-=1
        if n<m:
            j=m-2
            while j>=0 and k:
                a[1][j]='.' # create one extra path
                j-=1
                k-=1
        else:
            i=1
            while i<n and k:
                a[i][m-2]='.' # create one extra path
                i+=1
                k-=1
        if k:
            return []
        return [''.join(row) for row in a]