class Solution {
    public String smallestSubsequence(String s) {
        Stack<Character> st = new Stack<>();
        boolean taken[] = new boolean[26];
        int  lastSeen[] = new int[26];

        for(int i=0;i<s.length();i++){
            lastSeen[s.charAt(i)-'a'] = i;
        }

        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i) - 'a';
            if(taken[ind]) continue;

            while(!st.isEmpty() && st.peek()>s.charAt(i) && lastSeen[st.peek()-'a']>i){
                char c=st.pop();
                taken[c-'a'] = false;
            
            }
            st.push(s.charAt(i));
            taken[s.charAt(i)-'a'] = true;
        }

        StringBuilder res = new StringBuilder();

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}