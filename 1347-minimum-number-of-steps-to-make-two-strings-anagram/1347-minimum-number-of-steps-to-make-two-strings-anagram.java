class Solution {
    public int minSteps(String s, String t) {
        int freq[] = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<s.length();i++){
            freq[t.charAt(i)-'a']--;
        }
        int res = 0;

        for(int num :freq){
            if(num>0) res+=num;
        }
        return res;
    }
}