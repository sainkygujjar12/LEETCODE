class Solution {

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r = grid.length;
        int c = grid[0].length;

        int n = r * c;
        k %= n;

        reverse(grid, 0, n - 1, c);
        reverse(grid, 0, k - 1, c);
        reverse(grid, k, n - 1, c);

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < c; j++) {
                row.add(grid[i][j]);
            }
            ans.add(row);
        }

        return ans;
    }

    private void reverse(int[][] grid, int left, int right, int cols) {
        while (left < right) {
            swap(grid, left, right, cols);
            left++;
            right--;
        }
    }

    private void swap(int[][] grid, int i, int j, int cols) {
        int r1 = i / cols;
        int c1 = i % cols;

        int r2 = j / cols;
        int c2 = j % cols;

        int temp = grid[r1][c1];
        grid[r1][c1] = grid[r2][c2];
        grid[r2][c2] = temp;
    }
}