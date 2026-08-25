class Solution {
    class DSU{
        int parent[];
        int rank[];

        DSU(int n){
            parent = new int[n];
            rank = new int[n];

            for(int i=0;i<n;i++){
                parent[i] = i;
                rank[i] = 0;
            }
        }
        int find(int x){
            if(parent[x]==x) return x;
            return parent[x] = find(parent[x]);
        }

        void union(int a,int b){
            int pa = find(a);
            int pb = find(b);

            if(pa==pb) return;

            if(rank[pa]>rank[pb]){
                parent[pb] = pa;
            }else if(rank[pa]<rank[pb]){
                parent[pa] = pb;
            }else{
                parent[pb] = pa;
                rank[pa]++;
            }
        }
    }
    public int removeStones(int[][] stones) {
        
          int n = stones.length;

        DSU dsu = new DSU(n);

        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }
            }
        }

        
        int components = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                components++;
            }
        }

        return n - components;
    }
}
        
    
