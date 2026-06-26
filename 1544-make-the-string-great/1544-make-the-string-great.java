class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(!st.isEmpty() && Math.abs(c-st.peek()) == 32){
                st.pop();
            }else st.push(c);
        }

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}