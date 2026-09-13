class Solution {
    public int countSubstrings(String s) {
       int n =s.length();

       int PalindromeCount = 0;

       for(int i =0 ;  i<n ; i++){
        int oddLenCount = 1 + getPalindromeCout(i-1,i+1,s);
        int evenLenCount = getPalindromeCout(i,i+1,s);
          PalindromeCount += oddLenCount + evenLenCount;
          
       }
      return PalindromeCount;
    }   

    int getPalindromeCout(int l  , int r ,  String s){
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

    return count;

    }
}