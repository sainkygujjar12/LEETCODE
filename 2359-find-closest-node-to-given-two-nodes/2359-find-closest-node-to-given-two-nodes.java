class Solution {
    int n;

    void dfs(int[] edges, int node, int[] dist, boolean[] vis) {
        vis[node] = true;

        int v = edges[node];

        if (v != -1 && !vis[v]) {
            dist[v] = 1 + dist[node];
            dfs(edges, v, dist, vis);
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        n = edges.length;

        int[] dist1 = new int[n];
        int[] dist2 = new int[n];

        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];

        dist1[node1] = 0;
        dist2[node2] = 0;

        dfs(edges, node1, dist1, vis1);
        dfs(edges, node2, dist2, vis2);

        int ans = -1;
        int minMaxDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Node must be reachable from both node1 and node2
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);

                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    ans = i;
                }
            }
        }

        return ans;
    }
}
