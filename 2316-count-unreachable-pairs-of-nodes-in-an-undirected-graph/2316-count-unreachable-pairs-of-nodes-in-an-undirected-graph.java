class Solution {
    long result ;
    int N;

    public long dfs(Map<Integer,ArrayList<Integer>>adj,int u,boolean[] vis,long count){
        count = 1;
        vis[u]= true;
        if(adj.containsKey(u)){
            for(int v:adj.get(u)){
                if(!vis[v]){
                    count+=dfs(adj,v,vis,count);
                }
            }
           
        }
         return count;
    }
    public long countPairs(int n, int[][] edges) {
        boolean vis[] = new boolean[n];
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        result = 0;
        N = n;

        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u,k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v,k -> new ArrayList<>()).add(u);
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                long count = 0;
                long size =  dfs(adj,i,vis,count);
                result+= (N-size)*size;
                N-=size;
            }
        }

        return result;
        
    }
}