class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(s.charAt(i)=='('){
                stack.push(0);
            }else{
                int prev = stack.pop();
                int score = 0;
                if(prev==0) score = 1;
                else score = prev*2;
                if(!stack.isEmpty()){
                    stack.push(stack.pop()+score);
                }else stack.push(score);
            }
        }
        return stack.peek();
    }
}