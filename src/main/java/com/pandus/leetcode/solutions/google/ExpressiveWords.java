package com.pandus.leetcode.solutions.google;

import java.util.ArrayList;
import java.util.List;

public class ExpressiveWords {
    public int expressiveWords(String s, String[] words) {
        List<int[]> split1 = split(s);
        int answer = 0;
        for (String word : words) {
            List<int[]> split2 = split(word);
            if (split1.size() != split2.size()) {
                continue;
            }
            boolean valid = true;
            for (int n = 0; n < split1.size(); n++) {
                int char1 = split1.get(n)[0];
                int char1Count = split1.get(n)[1];
                int char2 = split2.get(n)[0];
                int char2Count = split2.get(n)[1];


                if ((char1 != char2)
                        || (char2Count > char1Count)
                        || (char1Count != char2Count && char1Count < 3)) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                answer++;
            }
        }
        return answer;
    }

    private List<int[]> split(String str) {
        List<int[]> groups = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            char currentChar = str.charAt(j);
            while (j < str.length() && str.charAt(j) == currentChar) {
                j++;
            }
            groups.add(new int[]{currentChar, j - i});
            i = j;
        }
        return groups;
    }
}
