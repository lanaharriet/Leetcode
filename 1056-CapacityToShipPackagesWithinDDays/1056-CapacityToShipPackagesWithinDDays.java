// Last updated: 7/16/2026, 4:10:02 PM
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int maxi = Integer.MIN_VALUE; // Minimum Capacity - Weight of Heaviest Package
        int sum = 0;                  // Maximum Capacity - if shipped in 1 day

        for(int num : weights) {
            maxi = Math.max(maxi, num);
            sum += num;
        }

        int low = maxi; 
        int high = sum;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            int needed = daysNeeded(weights, mid);

            if(needed <= days) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    public static int daysNeeded(int[] arr, int capacity) {
        int days = 1;
        int currLoad = 0;

        for(int w : arr) {
            if(currLoad + w > capacity) {
                days++;
                currLoad = w;
            }
            else {
                currLoad += w;
            }
        }
        return days;
    }
}