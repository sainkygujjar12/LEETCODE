class Solution {
    int n ;
    List<String> ans;
    public boolean isValid(String s){
        if(s.length()>0 && s.charAt(0)=='0') return false;

        int val = Integer.parseInt(s);
        return val <= 255;
    } 
    public void solve(String s , int ind, String curr, int part){
        if(ind==n && part==4){
            ans.add(curr.substring(0,curr.length()-1));
            return;
        }

        if(ind==n||part==4) return;

        if(ind+1<=n){
            solve(s,ind+1,curr+s.substring(ind,ind+1)+".",part+1);
        }
        if(ind+2<=n && isValid(s.substring(ind,ind+2))){
            solve(s,ind+2,curr + s.substring(ind,ind+2)+".",part+1);
        }
        if(ind+3<=n && isValid(s.substring(ind,ind+3))){
            solve(s,ind+3,curr + s.substring(ind,ind+3)+".",part+1);
        }
    }
    public List<String> restoreIpAddresses(String s) {
         n = s.length();
         ans = new ArrayList<>();

         if(n > 12) return ans;
         int part = 0;
         String curr = "";

         solve(s,0,curr,part);

         return ans;

    }
}