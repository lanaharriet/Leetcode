// Last updated: 8/11/2026, 9:22:38 AM
1public class Solution {
2    public int longestPalindrome(String s) {
3        // Initialize a set to keep track of characters with odd frequencies
4        HashSet<Character> charSet = new HashSet<>();
5        // Initialize the length of the longest palindrome
6        int length = 0;
7        
8        // Iterate over each character in the string
9        for (char c : s.toCharArray()) {
10            // If the character is already in the set, remove it and increase the length by 2
11            if (charSet.contains(c)) {
12                charSet.remove(c);
13                length += 2;
14            } else {
15                // If the character is not in the set, add it to the set
16                charSet.add(c);
17            }
18        }
19        
20        // If there are any characters left in the set, add 1 to the length for the middle character
21        if (!charSet.isEmpty()) {
22            length += 1;
23        }
24        
25        // Return the total length of the longest palindrome
26        return length;
27    }
28}