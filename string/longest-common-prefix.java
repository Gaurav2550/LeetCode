class Solution {
    public String longestCommonPrefix(String[] strs) {
       int minLength = strs[0].length();
        for(String s : strs){
            if(s.length() < minLength){
                minLength = s.length();
            }

        }


        for(int i = 0; i<minLength; i++){
            for(int j = 1; j<strs.length; j++){
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                   return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLength);
    }
}