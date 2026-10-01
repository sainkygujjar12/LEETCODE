class Solution {
    public int dfs( Map<Integer,ArrayList<Integer>> adj,List<Boolean> hasApple,int node , int parent){
        int time = 0;

        for(int edge:adj.getOrDefault(node,new ArrayList<>())){
            if(edge==parent) continue;
            int childTime = dfs(adj, hasApple, edge, node);


            if(childTime>0||hasApple.get(edge)){
                time+=2+childTime;
            }
        }

        return time;
    }
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();

        for(int []edge:edges){
            int u = edge[0];
            int v = edge[1];

            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(v);

            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(u);

        }
    
        return dfs(adj,hasApple,0,-1);
    }
}