class Solution {
    public int dfs(Map<Integer,List<int[]>>adj,int u , int parent){
        int ans = 0;

        for(int edge[] : adj.get(u)){
            int direction = edge[1];
            int v = edge[0];

            if(v==parent) continue;

            ans += direction;
            ans += dfs(adj,v,u);
        }
        return ans;
    }
    public int minReorder(int n, int[][] connections) {
        Map<Integer,List<int[]>>adj = new HashMap<>();

        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }

        for(int[] con:connections){
            int u = con[0];
            int v = con[1];
            adj.get(u).add(new int[]{v, 1});
            adj.get(v).add(new int[]{u, 0});
        }

        
        return dfs(adj,0,-1);
        
    }
}