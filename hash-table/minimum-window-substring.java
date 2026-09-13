import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowMap = new HashMap<>();
        int left = 0, right = 0;
        int required = targetMap.size();
        int formed = 0;
        
        int minLen = -1;
        int startIdx = 0;
        int endIdx = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);

            if (targetMap.containsKey(c) && 
                windowMap.get(c).intValue() == targetMap.get(c).intValue()) {
                formed++;
            }

            while (left <= right && formed == required) {
                if (minLen == -1 || (right - left + 1) < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                    endIdx = right;
                }

                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                
                if (targetMap.containsKey(leftChar) && windowMap.get(leftChar).intValue() < targetMap.get(leftChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLen == -1 ? "" : s.substring(startIdx, endIdx + 1);
    }
}