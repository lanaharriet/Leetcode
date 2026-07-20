# Last updated: 7/20/2026, 11:08:33 AM
class Solution(object):
    def minimumGroups(self, words):
        def get_min_rotation(s):
            n=len(s)
            s2=s+s
            f=[-1]*(2*n)
            k=0
            for j in range(1,2*n):
                sj=s2[j]
                i=f[j-k-1]
                while i!=-1 and sj!=s2[k+i+1]:
                    if sj<s2[k+i+1]:
                        k=j-i-1
                    i=f[i]

                if sj!=s2[k+i+1]:
                    if sj<s2[k]:
                        k=j
                    f[j-k]=-1

                else:
                    f[j-k]=i+1
            return s2[k:k+n]

        unique_groups=set()

        for w in words:
            even_sub=w[0::2]
            odd_sub=w[1::2]

            canonical_even=get_min_rotation(even_sub)
            canonical_odd=get_min_rotation(odd_sub)

            unique_groups.add((canonical_even, canonical_odd))

        return len(unique_groups)

                
        