# Last updated: 7/16/2026, 4:08:53 PM
class Solution(object):
    def canMakeSubsequence(self, s, t):
        m=len(s)
        n=len(t)

        pre=[-1]*m
        j=0
        for i in range(m):
            while j<n and t[j]!=s[i]:
                j+=1
            if j==n:
                break
            pre[i]=j
            j+=1

        if m==0 or pre[m-1]!=-1:
            return True

        suf = [-1]*m
        j=n-1
        for i in range(m-1,-1,-1):
            while j>=0 and t[j]!=s[i]:
                j-=1
            if j<0:
                break
            suf[i]=j
            j-=1

        for i in range(m):
            if i>0 and pre[i-1]==-1:
                continue
            if i<m-1 and suf[i+1]==-1:
                continue

            left=pre[i-1] if i>0 else -1
            right=suf[i+1] if i<m-1 else n

            if left+1 < right:
               return True

        return False
        