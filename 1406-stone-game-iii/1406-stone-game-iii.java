class Solution {
    int n ;
    int dp[];
    public int solve(int []s , int ind){
        if(ind>=n) return 0;

        if(dp[ind]!=-1) return dp[ind];

        int res = Integer.MIN_VALUE;

        int score = 0;
        if(ind<n){
            score += s[ind];
            res = Math.max(res,score-solve(s,ind+1));
        }
        if(ind+1<n){
            score+=s[ind+1];
            res = Math.max(res,score-solve(s,ind+2));
            
        }
        if(ind+2<n){
            score+=s[ind+2];
            res = Math.max(res,score-solve(s,ind+3));
            
        }
        return dp[ind]=res;
    }
    public String stoneGameIII(int[] stoneValue) {
         n = stoneValue.length;
         dp = new int[n];
         Arrays.fill(dp,-1);

        int ans = solve(stoneValue,0);

        if(ans>0) return "Alice";
        if(ans<0) return "Bob";
        else return "Tie";
    }
}