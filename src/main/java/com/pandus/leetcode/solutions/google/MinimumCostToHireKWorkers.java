package com.pandus.leetcode.solutions.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int[][] workers = new int[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new int[]{quality[i], wage[i]};
        }
        Arrays.sort(workers, Comparator.comparingDouble((int[] worker) -> (double) worker[1] / worker[0]));

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int sumQ = 0;
        double best = Double.MAX_VALUE;

        for (int[] worker : workers) {
            int q = worker[0];
            int w = worker[1];
            maxHeap.offer(q);
            sumQ += q;
            if (maxHeap.size() > k) {
                sumQ -= maxHeap.poll();
            }
            if (maxHeap.size() == k) {
                double r = (double) w / q;
                best = Math.min(best, r * sumQ);
            }
        }
        return best;
    }

}
