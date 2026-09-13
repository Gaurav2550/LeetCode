class Solution {
    public String reverseVowels(String s) {
      char[] ch =s.toCharArray();
        int l = 0; 
        int r = s.length()-1;
        while(l<r){

            while(l<=r && isVowel(ch[l])== false){
                l++;
            }
             while(l<=r && isVowel(ch[r])==false){
                r--;
            }

            if(l<r){
                char temp = ch[l];
                ch[l] = ch[r];
                ch[r] = temp;

                l++;
                r--;    
            }
        }
        return new String(ch);
    }

       
        boolean isVowel(char ch) {
    return (ch == 'a' || ch == 'A' ||
            ch == 'e' || ch == 'E' ||
            ch == 'i' || ch == 'I' ||
            ch == 'o' || ch == 'O' ||
            ch == 'u' || ch == 'U');
}

   }
    