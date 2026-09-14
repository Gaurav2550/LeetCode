class Solution {
    public boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        int[] sToT = new int[26];
        int[] tToS = new int[26];

        for (int i = 0; i < s.length(); i++) {

            int sIndex = s.charAt(i) - 'a';
            int tIndex = t.charAt(i) - 'a';

            // Check existing mapping conflict
            if ((sToT[sIndex] != 0 && sToT[sIndex] != tIndex + 1) ||
                (tToS[tIndex] != 0 && tToS[tIndex] != sIndex + 1)) {

                return false;
            }

            // Store mapping
            sToT[sIndex] = tIndex + 1;
            tToS[tIndex] = sIndex + 1;
        }

        return true;
    }
}