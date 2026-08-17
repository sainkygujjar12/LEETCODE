class Solution {
    int t [][] = new int[501][501];

    public int solve(int l , int r,int [] sum){
        if(l>=r) return 0;
        if (t[l][r] != -1) {
            return t[l][r];
        }

        int ans = 0;

        for (int k = l; k < r; k++) {

            int leftSum = sum[k] - (l > 0 ? sum[l - 1] : 0);
            int rightSum = sum[r] - sum[k];

            if (leftSum < rightSum) {
                ans = Math.max(ans, leftSum + solve(l, k, sum));

            } else if (leftSum > rightSum) {
                ans = Math.max(ans, rightSum + solve(k + 1, r, sum));

            } else {
                ans = Math.max(ans,
                        leftSum + Math.max(
                                solve(l, k, sum),
                                solve(k + 1, r, sum)
                        ));
            }
        }

        return t[l][r] = ans;

    }
    public int stoneGameV(int[] stoneValue) {
        int r = stoneValue.length;
        int l = 0;

        for(int num[]:t){
            Arrays.fill(num,-1);
        }
        int cumSum [] = new int[r];
        cumSum[0] = stoneValue[0];
        for(int i=1;i<r;i++){
            cumSum[i] = stoneValue[i] + cumSum[i-1];
        }

        return solve(l,r-1,cumSum);
        
    }
}