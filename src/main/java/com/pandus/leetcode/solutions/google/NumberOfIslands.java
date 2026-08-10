package com.pandus.leetcode.solutions.google;

public class NumberOfIslands {
    private char[][] grid;
    private static final char island = '1';
    private static final char water = '0';

    public int numIslands(char[][] grid) {
        this.grid = grid;
        int answer = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                char current = grid[r][c];
                if (current == island) {
                    answer++;
                    bfs(r, c);
                }
            }
        }
        return answer;
    }

    private void bfs(int row, int column) {
        if (row >= grid.length || column >= grid[0].length || row < 0 || column < 0) return;
        int current = grid[row][column];
        if (current == '1') {
            grid[row][column] = water;
            bfs(row, column + 1);
            bfs(row, column - 1);
            bfs(row + 1, column);
            bfs(row - 1, column);
        }
    }
}
