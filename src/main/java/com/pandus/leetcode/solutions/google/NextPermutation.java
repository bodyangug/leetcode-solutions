package com.pandus.leetcode.solutions.google;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 1. start iteration from the end
        // 2. find broken logic nums[i] < nums[i + 1]
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 3. find in the right side j that is grater than nums[i]
        int j = nums.length - 1;
        if (i >= 0) {
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 4. swap nums[i] and nums[j]
            swap(nums, i, j);
        }
        // 5. revers tail
        reverse(nums, i + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

