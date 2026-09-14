class Solution {
    int ans;
    public void dfs(int node,int c,int[]edges,boolean[] vis,boolean[] pathVis,int[] count){
        pathVis[node]=true;
        vis[node]=true;
        count[node] = c;

        int next = edges[node];
            if(next!=-1){
                if(!vis[next]){
                    dfs(next,c+1,edges,vis,pathVis,count);
                }else if(pathVis[next]){
                    ans = Math.max(ans,count[node]-count[next]+1);
                }
            }
        pathVis[node] = false;

    }
    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean vis[] = new boolean[n];
        boolean pathVis[] = new boolean[n];
        int []count = new int[n];
        ans = -1;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,0,edges,vis,pathVis,count);
            }
        }
        return ans;

    }
}