// Last updated: 7/16/2026, 4:08:58 PM
import java.util.Arrays;

class FenwickTree {
    int n;
    long[] tree;

    FenwickTree(int n) {
        this.n = n;
        tree = new long[n + 1];
    }

    void clear() {
        Arrays.fill(tree, 0);
    }

    void copyFrom(FenwickTree other) {
        System.arraycopy(other.tree, 0, this.tree, 0, this.n + 1);
    }

    void add(int i, long val) {
        for (i++; i <= n; i += i & -i) {
            tree[i] += val;
        }
    }

    long sum(int i) {
        long res = 0;
        for (i++; i > 0; i -= i & -i) {
            res += tree[i];
        }
        return res;
    }

    int lower_bound(long sum) {
        int ind = 0;
        long curr = 0;
        for (int i = Integer.highestOneBit(n); i > 0; i >>= 1) {
            if (ind + i <= n && curr + tree[ind + i] < sum) {
                curr += tree[ind + i];
                ind += i;
            }
        }
        return ind;
    }
}

class Solution {
    private int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long apply(FenwickTree BIT, FenwickTree cnt, int firstK, long curr, int len, boolean inside, int n, long tot) {
        if (firstK == 0 || firstK > Math.min(len, n - len)) return 0;
        if (inside) {
            return BIT.sum(cnt.lower_bound(firstK));
        }
        int ind = cnt.lower_bound(n - len - firstK);
        return tot - curr - BIT.sum(ind);
    }

    private boolean isValid(int mid, FenwickTree intCnt, FenwickTree extCnt, int n, int len) {
        if (mid == 0) return true;
        return intCnt.lower_bound(mid) < extCnt.lower_bound(n - len - mid + 1);
    }

    public long maxSum(int[] nums, int k) {
        int n = nums.length;

        int[] temp = nums.clone();
        Arrays.sort(temp);

        int[] top = new int[n];
        int[] pos = new int[n];
        FenwickTree baseCnt = new FenwickTree(n);
        FenwickTree baseSum = new FenwickTree(n);
        
        for (int i = 0; i < n; i++) {
            int ind = lowerBound(temp, nums[i]);
            pos[i] = ind + top[ind];
            baseCnt.add(pos[i], 1);
            baseSum.add(pos[i], nums[i]);
            top[ind]++;
        }

        long tot = 0;
        for (int num : nums) {
            tot += num;
        }

        FenwickTree intSum = new FenwickTree(n);
        FenwickTree intCnt = new FenwickTree(n);
        FenwickTree extSum = new FenwickTree(n);
        FenwickTree extCnt = new FenwickTree(n);

        long ans = (long) -1e18;
        
        for (int len = 1; len <= n; len++) {
            intSum.clear();
            intCnt.clear();
        
            extSum.copyFrom(baseSum);
            extCnt.copyFrom(baseCnt);

            int best = 0;
            long curr = 0;
            for (int i = 0; i < n; i++) {
                int r = pos[i];
                curr += nums[i];

                intCnt.add(r, +1);
                extCnt.add(r, -1);

                intSum.add(r, +nums[i]);
                extSum.add(r, -nums[i]);
                
                if (i + 1 < len) continue;
                
                if (i + 1 > len) {
                    int l = pos[i - len];
                    curr -= nums[i - len];

                    intCnt.add(l, -1);
                    extCnt.add(l, +1);

                    intSum.add(l, -nums[i - len]);
                    extSum.add(l, +nums[i - len]);
                }

                int maxOp = Math.min(k, Math.min(len, n - len));

                if (i + 1 == len) {
                    int low = 0, high = maxOp;
                    while (low <= high) {
                        int mid = (low + high) / 2;
                        if (isValid(mid, intCnt, extCnt, n, len)) {
                            best = mid;
                            low = mid + 1;
                        }
                        else {
                            high = mid - 1;
                        }
                    }
                }
                else if (best < maxOp && isValid(best + 1, intCnt, extCnt, n, len)) {
                    best++;
                }

                long inside  = apply(intSum, intCnt, best, curr, len, true, n, tot);
                long outside = apply(extSum, extCnt, best, curr, len, false, n, tot);
                ans = Math.max(ans, curr - inside + outside);
            }
        }
        return ans;
    }
}