package com.pandus.leetcode.solutions.google;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) maxHeap.offer(num);

        for (int i = 0; i < k - 1; i++) maxHeap.poll();
        return maxHeap.peek();
    }
}
