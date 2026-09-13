
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int totalLen = wordLen * totalWords;
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentWindow = new HashMap<>();
            
            while (right + wordLen <= s.length()) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;
                
                if (wordCount.containsKey(word)) {
                    currentWindow.put(word, currentWindow.getOrDefault(word, 0) + 1);
                    count++;
                    
                    while (currentWindow.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        currentWindow.put(leftWord, currentWindow.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    currentWindow.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        
        return result;
    }
}