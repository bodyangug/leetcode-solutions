package com.pandus.leetcode.solutions.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        int L = words[0].length();
        int total = L * words.length;
        Map<String, Integer> need = new HashMap<>();
        for (String w : words) need.merge(w, 1, Integer::sum);

        for (int i = 0; i <= s.length() - total; i++) {
            Map<String, Integer> window = new HashMap<>();
            for (int j = 0; j < words.length; j++) {
                String piece = s.substring(i + j * L, i + (j + 1) * L);
                window.put(piece, window.getOrDefault(piece, 0) + 1);
            }

            if (window.equals(need))
                ans.add(i);
        }
        return ans;
    }
}
