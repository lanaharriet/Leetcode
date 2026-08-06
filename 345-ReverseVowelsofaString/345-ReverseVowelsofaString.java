// Last updated: 8/6/2026, 9:35:34 AM
1class Solution {
2    public String reverseVowels(String s) {
3        char[] word = s.toCharArray();
4        int start = 0;
5        int end = s.length() - 1;
6        String vowels = "aeiouAEIOU";
7        
8        while (start < end) {
9            // Move start pointer until it points to a vowel
10            while (start < end && vowels.indexOf(word[start]) == -1) {
11                start++;
12            }
13            
14            // Move end pointer until it points to a vowel
15            while (start < end && vowels.indexOf(word[end]) == -1) {
16                end--;
17            }
18            
19            // Swap the vowels
20            char temp = word[start];
21            word[start] = word[end];
22            word[end] = temp;
23            
24            // Move the pointers towards each other
25            start++;
26            end--;
27        }
28        
29        String answer = new String(word);
30        return answer;
31    }
32}