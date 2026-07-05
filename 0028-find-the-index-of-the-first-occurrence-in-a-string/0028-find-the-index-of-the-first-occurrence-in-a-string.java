class Solution {
    public int strStr(String haystack, String needle) {
        
        int n = needle.length();
        if(n>haystack.length()) return -1;
        for(int i=0;i<=haystack.length()-n;i++){
            int j = 0;

            while(j<n && haystack.charAt(i+j)==needle.charAt(j)){
                j++;
            }
            if(j==n) return i;
        }
        return -1;
    }
}