class Solution {
    int ans;
    public void dfs(List<int[]>[] adj,boolean vis[], int u){
        vis[u] = true;

        for(int edge[]:adj[u]){
            int next = edge[0];
            int wt = edge[1];

            ans = Math.min(ans,wt);


            if(!vis[next]){
                dfs(adj,vis,next);
            }
        }
    }
    public int minScore(int n, int[][] roads) {
        ans = Integer.MAX_VALUE;
        List<int[]>[] adj = new ArrayList[n+1];
        
        for(int i=1;i<=n;i++){
            adj[i] = new ArrayList<>();
        }

        for(int road[]:roads){
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            adj[u].add(new int[]{v,wt});
            adj[v].add(new int[]{u, wt});
        }

        boolean vis[] = new boolean[n+1];
        dfs(adj,vis,1);
        return ans;

        
        
    }
}