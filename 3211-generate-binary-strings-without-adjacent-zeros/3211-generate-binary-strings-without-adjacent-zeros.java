class Solution {
    List<String> ans;
    public List<String> validStrings(int n) {
        StringBuilder res = new StringBuilder();
        ans = new ArrayList<>();
        backTrack(n,res);

        return ans;
        
    }
    public void backTrack(int n, StringBuilder res){
        if(res.length()==n){
            ans.add(res.toString());
            return;
        }

        res.append('1');
        backTrack(n,res);

        res.deleteCharAt(res.length()-1);

        if(res.length()==0||res.charAt(res.length()-1)!='0'){
            res.append('0');
            backTrack(n,res);
            res.deleteCharAt(res.length()-1);

        }
    }
}