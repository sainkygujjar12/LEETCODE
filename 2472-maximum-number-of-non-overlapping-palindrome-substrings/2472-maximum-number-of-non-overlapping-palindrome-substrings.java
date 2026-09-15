class Solution {
    boolean [][] pal;
    public int solve(String s,int k, int i,int[]dp){
        int ans = 0;
        if(i>=s.length()) return 0;
        if(dp[i]!=-1) return dp[i];
        ans = Math.max(ans,solve(s,k,i+1,dp));
        for(int j=i+k-1;j<s.length();j++){
            if(pal[i][j]){
                ans = Math.max(ans,1+solve(s,k,j+1,dp));
            }
        }

        return dp[i] = ans;

    }
    public boolean  isPalindrome(String s,int i ,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int dp[] = new int[s.length()];
        Arrays.fill(dp,-1);
        pal = new boolean[n][n];

        // Precompute palindromes
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }

        return solve(s,k,0,dp);

    }
}