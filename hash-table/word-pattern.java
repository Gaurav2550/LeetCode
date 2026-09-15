class Solution {
    public boolean wordPattern(String pattern, String s) {
         
         String[] words =  s.split(" ");
           
           if(pattern.length()!= words.length){
            return false ;
           }

           // 
           Map<Character,String> patternToWord = new HashMap();
              Map<String,Character> wordToPattern = new HashMap();

              for(int i =0;i<words.length; i++){
                char ch = pattern.charAt(i);
                String word = words[i];
              

              if(patternToWord.containsKey(ch) && !patternToWord.get(ch).equals(word)){
                return false;
              }
              
              
              if( wordToPattern.containsKey(word)&&  wordToPattern.get(word)!=ch){
                return false;
              }

               patternToWord.put(ch,word);
               wordToPattern.put(word,ch);
            
              }

              return true;
    }
}