# Last updated: 7/20/2026, 11:08:32 AM
class Solution(object):
    def transformStr(self, s, strs):
        n=len(s)
        k=s.count('1')

        pref_s =[0]*n
        curr=0
        for i in range(n):
            if s[i]=='1':
                curr+=1
            pref_s[i]=curr

        ans=[]
        for t in strs:
            fixed_ones=t.count('1')
            q_count=t.count('?')

            if fixed_ones>k or fixed_ones +q_count<k:
                ans.append(False)
                continue

            needed_ones=k-fixed_ones

            q_seen=0
            possible=True
            pref_t_curr=0

            for i in range(n):
                char=t[i]
                if char=='?':
                    q_seen+=1

                    if q_count - q_seen<needed_ones:
                        pref_t_curr+=1
                elif char=='1':
                    pref_t_curr+=1

                if pref_t_curr>pref_s[i]:
                    possible=False
                    break

            ans.append(possible)
        return ans