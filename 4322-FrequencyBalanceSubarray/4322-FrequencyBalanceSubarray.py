# Last updated: 7/16/2026, 4:08:56 PM
class Solution(object):
    def getLength(self, nums):
        n=len(nums)
        ans = 1

        for i in range(n):
            freq={}
            freqCount={}

            for j in range(i,n):
                x=nums[j]

                oldFreq=freq.get(x,0)

                if oldFreq>0:
                    freqCount[oldFreq]-=1
                    if freqCount[oldFreq]==0:
                        del freqCount[oldFreq]

                newFreq=oldFreq+1
                freq[x]=newFreq
                freqCount[newFreq]=freqCount.get(newFreq,0)+1

                length=j-i+1

                if length==1:
                    ans=max(ans,1)
                    continue

                if len(freqCount)==1:
                    f=next(iter(freqCount))

                    if freqCount[f]==1:
                        ans=max(ans,length)

                elif len(freqCount)==2:
                    f1,f2= sorted(freqCount.keys())

                    if f2 == 2*f1:
                        ans = max(ans,length)
                  

        return ans
                    
        
        