class Solution {
    public int countHomogenous(String s) {
        long ans = 0;
        long curr = 1;
        long MOD = 1_000_000_007;

        for(int i =0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                curr++;
            }else{
               ans = (ans + curr * (curr + 1) / 2) % MOD;
               curr = 1;
            }
        }
         ans = (ans + curr * (curr + 1) / 2) % MOD;
         return (int) ans;


    }
}