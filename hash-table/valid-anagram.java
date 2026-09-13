class Solution {
    public boolean isAnagram(String s, String t) {

         int  n = s.length();
        int   m = t.length();
            
            // length check
     
          if(n!=m){
            return false;
          }
          
          // frequency array
          int[] count = new int[26];

          for(char ch : s.toCharArray()){
             count[ch-'a']++;
          }

          for(char  ch : t.toCharArray()){
              count[ch-'a']--;
          }

          for(int c: count){
            if(c!=0){
                return false;
            }
          
          }
          
            return true;

    }
}