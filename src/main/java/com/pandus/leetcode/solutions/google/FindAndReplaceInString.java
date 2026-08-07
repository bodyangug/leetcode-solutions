package com.pandus.leetcode.solutions.google;

import java.util.HashMap;
import java.util.Map;

public class FindAndReplaceInString {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Map<Integer, String[]> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            String source = sources[i];
            String target = targets[i];
            int index = indices[i];
            if (s.startsWith(source, index)) {
                map.put(index, new String[]{source, target});
            }
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(i)) {
                String[] el = map.get(i);
                String source = el[0];
                String target = el[1];
                sb.append(target);
                i += source.length() - 1;
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
