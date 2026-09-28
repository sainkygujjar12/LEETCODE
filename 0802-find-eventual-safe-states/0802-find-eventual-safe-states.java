class Solution {
    public boolean dfs(int node,int [][]graph,int[]vis,int[]check,int[] path){
        check[node]=0;
        vis[node]=1;
        path[node]=1;
        for(int it:graph[node]){
            if(vis[it]==0){
                if(dfs(it,graph,vis,check,path)) return true;
            }else{
                if(path[it]==1) return true;
            }
        }
        check[node]=1;
        path[node]=0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        int vis[]=new int [v];
        int pathvis[]=new int[v];
        int check[]=new int[v];
        for(int i=0;i<v;i++){
            if(vis[i]==0){
                dfs(i,graph,vis,check,pathvis);
            }
        } 
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<v;i++){
            if(check[i]==1) ans.add(i);
        }
        return ans;
    }
}