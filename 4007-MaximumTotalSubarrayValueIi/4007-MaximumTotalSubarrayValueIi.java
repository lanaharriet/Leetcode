// Last updated: 7/16/2026, 4:09:04 PM
import java.util.PriorityQueue;

class Solution {
    // Sparse tables for fast range max and min queries
    private int[][] maxTable;
    private int[][] minTable;
    private int[] logTable;

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        buildSparseTables(nums, n);

        // Max-heap stores elements as: new long[]{subarray_value, left_index, right_index}
        // Sorted in descending order of subarray_value
        PriorityQueue<long[]> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        // Initialize the heap with the largest subarray for each starting index l (which is r = n - 1)
        for (int l = 0; l < n; l++) {
            long val = getSubarrayValue(l, n - 1);
            maxHeap.offer(new long[]{val, l, n - 1});
        }

        long maxTotalSum = 0;

        // Extract the top k largest valid subarrays
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;

            long[] current = maxHeap.poll();
            long val = current[0];
            int l = (int) current[1];
            int r = (int) current[2];

            maxTotalSum += val;

            // If we can shrink the right bound further, push the next best choice (l, r - 1)
            if (r > l) {
                long nextVal = getSubarrayValue(l, r - 1);
                maxHeap.offer(new long[]{nextVal, l, r - 1});
            }
        }

        return maxTotalSum;
    }

    private void buildSparseTables(int[] nums, int n) {
        int maxLog = 31 - Integer.numberOfLeadingZeros(n);
        maxTable = new int[n][maxLog + 1];
        minTable = new int[n][maxLog + 1];
        logTable = new int[n + 1];

        // Precompute logarithm values
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i >> 1] + 1;
        }

        // Initialize base cases
        for (int i = 0; i < n; i++) {
            maxTable[i][0] = nums[i];
            minTable[i][0] = nums[i];
        }

        // Populate sparse tables
        for (int j = 1; j <= maxLog; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                maxTable[i][j] = Math.max(maxTable[i][j - 1], maxTable[i + (1 << (j - 1))][j - 1]);
                minTable[i][j] = Math.min(minTable[i][j - 1], minTable[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    private long getSubarrayValue(int l, int r) {
        if (l > r) return 0;
        int len = r - l + 1;
        int k = logTable[len];
        
        int maxVal = Math.max(maxTable[l][k], maxTable[r - (1 << k) + 1][k]);
        int minVal = Math.min(minTable[l][k], minTable[r - (1 << k) + 1][k]);
        
        return (long) maxVal - minVal;
    }
}