class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
          Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            // 1. Convert string into character array
            char[] chars = str.toCharArray();

            // 2. Sort characters
            Arrays.sort(chars);

            // 3. Create common key
            String key = new String(chars);

            // 4. If key doesn't exist, create new list
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // 5. Add original string to that group
            map.get(key).add(str);
        }

        // 6. Return all groups
        return new ArrayList<>(map.values());
    }
}