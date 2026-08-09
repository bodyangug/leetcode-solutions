package com.pandus.leetcode.solutions.google;

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = Integer.MIN_VALUE;
        int N = seats.length;
        int prevPerson = -1;
        for (int i = 0; i < N; i++) {
            if (seats[i] == 0) {
                int next = -1;
                for (int future = i; future < N; future++) {
                    if (seats[future] == 1) {
                        next = future;
                        break;
                    }
                }

                int left = prevPerson == -1 ? N : i - prevPerson;
                int right = next == -1 ? N : next - i;
                maxDistance = Math.max(maxDistance, Math.min(left, right));
            } else {
                prevPerson = i;
            }
        }
        return maxDistance;
    }
}
