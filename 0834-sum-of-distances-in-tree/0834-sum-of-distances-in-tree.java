class Solution {
    long resultBaseNode = 0;
        int [] count ;
        int N;

    int dfsBase(Map<Integer,List<Integer>>adj, int currNode , int prevNode,int currDepth){
        int totalNode = 1;

        resultBaseNode+=currDepth;
        for(int child :adj.getOrDefault(currNode , new ArrayList<>())){
            if(child==prevNode) continue;

            totalNode+= dfsBase(adj,child,currNode,currDepth+1);
        }
        count[currNode] = totalNode;
        return totalNode;
    }

    void dfs(Map<Integer,List<Integer>>adj, int currNode , int prevNode,int[] result){
        for(int child : adj.getOrDefault(currNode,new ArrayList<>())){
            if(child==prevNode){
                continue;
            }
            result[child] = result[currNode]-count[child]+(N-count[child]);
            dfs(adj,child,currNode,result);
        }
    }
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        N = n;
        count = new int[n];

        // Build adjacency list
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        resultBaseNode = 0;

        // Calculate subtree sizes and answer for node 0
        dfsBase(adj, 0, -1, 0);

        int[] result = new int[n];

        result[0] = (int) resultBaseNode;

        // Calculate answers for all other nodes
        dfs(adj, 0, -1, result);

        return result;
    }
}

        
 