class DSU{
    int [] parent;
    int [] rank;

    public DSU(int n){
        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x]!=x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x,int y){
        int px = find(x);
        int py = find(y);
        
        if(px==py) return ;

        if(rank[px]>rank[py]){
            parent[py] = px;
            rank[px]++;
        }else if(rank[py]>rank[px]){
            parent[px]=py;
            rank[py]++;
        }else {
            parent[py] = px;
            rank[px]++;
        }
    }
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU(26);
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';
                dsu.union(u, v);
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int u = eq.charAt(0) - 'a';
                int v = eq.charAt(3) - 'a';

                if (dsu.find(u) == dsu.find(v)) {
                    return false;
                }
            }
        }

        return true;
    }
}