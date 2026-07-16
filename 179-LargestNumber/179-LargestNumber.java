// Last updated: 7/16/2026, 4:12:23 PM
import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // 1. Convert the integer array to a String array
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        
        // 2. Custom Sort: Compare concatenated results (b + a vs a + b)
        // This sorts the strings in descending order of their combined value
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // 3. Edge Case: If the largest number is "0", the result is just "0"
        // This handles cases like [0, 0, 0] instead of returning "000"
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // 4. Concatenate the sorted strings
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}