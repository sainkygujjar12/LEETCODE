class Solution {
    int result = 0;
    public int dfs(Map<Integer,List<Integer>> adj, int curr,int parent, String s){

        int longest = 0;
        int secondL = 0;

        for(int child:adj.getOrDefault(curr,new ArrayList<>())){
            if(child==parent) continue;
            
            int childLongest = dfs(adj,child,curr,s);

            if(s.charAt(child)==s.charAt(curr)) continue;

            if(childLongest>secondL){
                secondL = childLongest;
            }

            if(secondL>longest){
                int temp = longest;
                longest = secondL;
                secondL = temp;
            }
        }

        int onlyOne = Math.max(longest,secondL) + 1;
        int root = 1;

        int down = longest + secondL + 1;

        result = Math.max(result,Math.max(onlyOne,Math.max(root,down)));

        return Math.max(onlyOne,root);
    }
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        result = 0;
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=1;i<n;i++){
            int u = i;
            int v = parent[i];
            adj.computeIfAbsent(u,k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k -> new ArrayList<>()).add(u);
        }

        dfs(adj,0,-1,s);
        return result;
    }
}