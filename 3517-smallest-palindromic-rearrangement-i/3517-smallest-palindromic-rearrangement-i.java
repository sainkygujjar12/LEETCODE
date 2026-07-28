class Solution {
    public String smallestPalindrome(String s) {
        int freq[] = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();
        char odd = 0;

        for(int i=0;i<26;i++){
            for(int j=0;j<freq[i]/2;j++){
                sb.append((char) ('a'+i));
            }
            if(freq[i] % 2 == 1){
                odd = (char) ('a' + i);
            }
        }

        StringBuilder ans = new StringBuilder(sb);

        if(odd!=0){
            ans.append(odd);
        }

        ans.append(new StringBuilder(sb).reverse());
        return ans.toString();
    }
}