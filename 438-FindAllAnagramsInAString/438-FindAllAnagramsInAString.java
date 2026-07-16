// Last updated: 7/16/2026, 4:11:17 PM
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s == null || p == null || s.length() < p.length()) {
            return result;
        }

        int[] count = new int[26];
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }
        
        int left = 0;
        int right = 0;
        int diff = p.length(); 
        
        while (right < s.length()) {
            if (count[s.charAt(right) - 'a'] >= 1) {
                diff--;
            }
            count[s.charAt(right) - 'a']--;
            right++;
            
            if (diff == 0) {
                result.add(left);
            }
            
            if (right - left == p.length()) {
                if (count[s.charAt(left) - 'a'] >= 0) {
                    diff++;
                }
                count[s.charAt(left) - 'a']++;
                left++;
            }
        }
        
        return result;
    }
}
