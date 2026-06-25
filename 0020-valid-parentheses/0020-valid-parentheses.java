class Solution {
    public boolean isValid(String s) {
        Stack<Character>set=new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

           if(ch=='('||ch=='['||ch=='{'){
                set.push(ch);
            }
            else {
                if(set.isEmpty()) return false;
                if((set.peek()=='('&&ch==')')||(set.peek()=='['&&ch==']')||(set.peek()=='{'&&ch=='}')){
                    set.pop();
                }else{
                    return false;
                }
            }
            }
            if(!set.isEmpty()) return false;
            else return true;
        }
        
    }