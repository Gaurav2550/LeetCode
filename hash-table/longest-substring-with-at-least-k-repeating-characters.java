import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length(), k);
    }

    private int helper(String s, int start, int end, int k) {
        if (end - start < k) return 0;

        // 1. Build frequency map for the current substring range
        Map<Character, Integer> counts = new HashMap<>();
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }

        // 2. Iterate through the substring to find an invalid character
        for (int i = start; i < end; i++) {
            char c = s.charAt(i);
            if (counts.get(c) < k) {
                // Found a 'split point'. The result is the max of the left 
                // side and the right side (skipping the invalid character).
                int left = helper(s, start, i, k);
                
                // Skip additional invalid characters to save recursion depth
                int j = i + 1;
                while (j < end && counts.get(s.charAt(j)) < k) {
                    j++;
                }
                
                int right = helper(s, j, end, k);
                return Math.max(left, right);
            }
        }

        // 3. If we finish the loop, all characters in this range meet the requirement
        return end - start;
    }
}