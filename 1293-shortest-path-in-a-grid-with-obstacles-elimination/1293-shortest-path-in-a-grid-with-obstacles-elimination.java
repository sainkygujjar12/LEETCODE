class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][][] = new boolean[n][m][k+1];
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,k});
        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        vis[0][0][k] = true;

        int steps = 0;

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                int curr[] = q.poll();
                int i = curr[0];
                int j = curr[1];
                int obs = curr[2];

                if(i==n-1&&j==m-1) return steps++;

                for(int []dir :directions){
                    int ni = i + dir[0];
                    int nj = j+dir[1];

                    if(ni<0||ni>=n||nj<0||nj>=m) continue;

                    if(grid[ni][nj]==0 && !vis[ni][nj][obs]){
                        q.add(new int[]{ni,nj,obs});
                        vis[ni][nj][obs] = true;
                    }else if(grid[ni][nj]==1 && obs>0 && !vis[ni][nj][obs-1]){
                        q.add(new int[]{ni,nj,obs-1});
                        vis[ni][nj][obs-1] = true;
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}