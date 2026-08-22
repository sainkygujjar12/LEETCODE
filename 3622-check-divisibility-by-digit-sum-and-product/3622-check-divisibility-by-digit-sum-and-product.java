class Solution {
    int sum ;
    int pro ;

    public void solve(int n){
        while(n>0){
            int digit = n%10;
            pro*=digit;
            sum += digit;
            n/=10;
        }
    }
    public boolean checkDivisibility(int n) {
        sum = 0;
        pro = 1;
        solve(n);

        int res = sum + pro;
        if(n%res==0) return true;
        else return false; 
        
    }
}