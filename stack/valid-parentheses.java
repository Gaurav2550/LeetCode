class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();   

        for(char ch : s.toCharArray()){
            if(ch =='(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else{
                 if(stack.isEmpty()){
                    return false;
                 }

                 char top =  stack.pop();

                if( (ch ==')' && ch !='(') ||
                    (ch ==']' && ch !='[') ||
                    (ch =='}' && ch !='{') 
                ){

                    return false;

                }
            
            }


        }

        return stack.isEmpty();
    }
}