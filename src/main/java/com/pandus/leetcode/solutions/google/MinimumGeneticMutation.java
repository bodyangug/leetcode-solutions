package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        int ans = 0;
        char[] gens = new char[]{'A', 'C', 'G', 'T'};
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashSet<String> newBank = new HashSet<>(Arrays.asList(bank));
        queue.add(startGene);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                String curr = queue.poll();
                if (curr.equals(endGene)) return ans;
                char[] currChars = curr.toCharArray();
                for (int c = 0; c < currChars.length; c++) {
                    char orig = currChars[c];
                    for (char gen : gens) {
                        if (currChars[c] == gen) continue;

                        currChars[c] = gen;
                        String newGen = new String(currChars);
                        if (newBank.contains(newGen)) {
                            queue.add(newGen);
                            newBank.remove(newGen);
                        }
                        currChars[c] = orig;
                    }
                }
            }
            ans++;
        }
        return -1;
    }
}
