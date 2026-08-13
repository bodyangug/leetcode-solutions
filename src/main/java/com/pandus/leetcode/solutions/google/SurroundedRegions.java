package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;

public class SurroundedRegions {
    private char[][] board;
    private int[][] dirs = new int[][]{
            {0, 1}, // left
            {1, 0}, // up
            {0, -1}, // right
            {-1, 0} // down
    };

    public void solve(char[][] board) {
        this.board = board;
        int rows = board.length;
        int cols = board[0].length;
        for (int r = 0; r < rows; r++) {
            mark(r, 0);
            mark(r, cols - 1);
        }

        for (int c = 0; c < cols; c++) {
            mark(0, c);
            mark(rows - 1, c);
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if (board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void mark(int r, int c) {
        if (board[r][c] != 'O') return;

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{r, c});
        board[r][c] = 'S';

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            for (int[] dir : dirs) {
                int newR = poll[0] + dir[0];
                int newC = poll[1] + dir[1];

                if (newR >= board.length || newC >= board[0].length || newC < 0 || newR < 0)
                    continue;

                if (board[newR][newC] != 'O') continue;
                board[newR][newC] = 'S';

                queue.add(new int[]{newR, newC});

            }
        }
    }
}
