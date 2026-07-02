class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int [][] bestHealth = new int[n][m];
        for(int row[]:bestHealth){
            Arrays.fill(row,-1);
        }

        Queue<int[]> q = new LinkedList<>();
        int start = health - grid.get(0).get(0);
        if(start<=0) return false;

        q.add(new int[]{0,0,start});
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        bestHealth[0][0] = start;

        while(!q.isEmpty()){
            int [] curr = q.poll();
            int newHealth = curr[2];
            int row = curr[0];
            int col = curr[1];
            if(row==n-1 && col==m-1) return true;

            for(int d[]:dirs){
                int nrow = row + d[0];
                int ncol = col + d[1];

                if(nrow<0 || nrow>=n ||ncol<0 || ncol>=m) continue;

                int nextHealth = newHealth - grid.get(nrow).get(ncol);

                if(nextHealth<=0) continue;

                if(nextHealth>bestHealth[nrow][ncol]){
                    bestHealth[nrow][ncol] = nextHealth;
                    q.add(new int[]{nrow,ncol,nextHealth});
                }
            }
        }

        return false;
        
    }
}