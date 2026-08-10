package com.pandus.leetcode.solutions.google;

public class LongestIncreasingPathInMatrix {

    private int[][] memo;
    private int[][] dirs = new int[][]{
            {-1, 0}, // left
            {1, 0}, // right
            {0, 1}, // up
            {0, -1} // down
    };
    private int[][] matrix;

    public int longestIncreasingPath(int[][] matrix) {
        this.matrix = matrix;
        memo = new int[matrix.length][matrix[0].length];
        int best = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                best = Math.max(best, dfs(r, c));
            }
        }

        return best;
    }

    private int dfs(int r, int c) {
        if (memo[r][c] != 0) return memo[r][c];
        int result = 1;

        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (nr >= memo.length || nc >= memo[0].length || nr < 0 || nc < 0) continue;
            if (matrix[nr][nc] <= matrix[r][c]) continue;
            result = Math.max(result, 1 + dfs(nr, nc));
        }
        memo[r][c] = result;
        return result;
    }
}


//longestIncreasingPath(matrix):
//    memo = int[rows][cols]        // 0 = ещё не считали
//    best = 0
//    для каждой клетки (r, c):
//        best = max(best, dfs(r, c))
//    вернуть best
//
//dfs(r, c):
//    если memo[r][c] != 0 -> вернуть memo[r][c]
//    result = 1                     // сама клетка уже путь длины 1
//    для каждого из 4 направлений:
//        (nr, nc) = сосед
//        границы -> continue
//        если matrix[nr][nc] <= matrix[r][c] -> continue   // строго возрастает!
//        result = max(result, 1 + dfs(nr, nc))
//    memo[r][c] = result
//    вернуть result