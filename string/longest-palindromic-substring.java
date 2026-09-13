class Solution {
    public String longestPalindrome(String s) {
         int n =s.length();
           
        String subStrinPallindrome = "";   

       int len = 0;

       for(int i =0 ;  i<n ; i++){
        String oddLenCount = getPalindromeCout(i-1,i+1,s);
        String evenLenCount = getPalindromeCout(i,i+1,s);
       
         if(len<oddLenCount.length()){
           subStrinPallindrome = oddLenCount;
           len = oddLenCount.length();
         }

         if(len<evenLenCount.length()){
           subStrinPallindrome = evenLenCount;
           len = evenLenCount.length();
         }



          
       }
      return subStrinPallindrome;
    }   
    
    String getPalindromeCout(int l  , int r ,  String s){
      int n = s.length();
      int count = 0;
      while(l>=0 && r<n){
        if(s.charAt(l) == s.charAt(r)){
           count ++;
           l--;
           r++;

        }else{
            break;
        }

      }

    return s.substring(l + 1 , r);

 }
}