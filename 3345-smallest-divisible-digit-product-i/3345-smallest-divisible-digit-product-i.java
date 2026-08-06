class Solution {
    public int digitP(int n){
        int prod = 1;
        while(n>0){
            prod*=n%10;
            n/=10;
        }
        return prod;
    }
    public int smallestNumber(int n, int t) {
        while(true){
            if(digitP(n) % t == 0) return n;
            else n++;
        }
    }
}