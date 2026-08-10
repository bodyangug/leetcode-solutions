package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] answer = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            int ai = prerequisite[0];
            int bi = prerequisite[1];
            indegree[ai] += 1;
            adj.get(bi).add(ai);
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) deque.offer(i);
        }
        int lastIdx = 0;
        while (!deque.isEmpty()) {
            int course = deque.poll();
            answer[lastIdx] = course;
            lastIdx++;

            List<Integer> adjCourses = adj.get(course);
            for (int next : adjCourses) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    deque.add(next);
                }
            }
        }

        if (lastIdx != numCourses) return new int[0];
        return answer;
    }
}
