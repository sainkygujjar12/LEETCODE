class Solution {
    public void solve(int n, int open , int close , String curr,ArrayList<String> res){
        if(curr.length()==2*n){
            res.add(curr);
            return;
        }

        if(open<n){
            solve(n,open+1,close,curr+'(',res);
        }
        if(close<open && close<n){
            solve(n,open,close+1,curr+')',res);
        }
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<>();
        int open = 0;
        int close = 0;

        solve(n,open,close,"",res);
        return res;
    }
}