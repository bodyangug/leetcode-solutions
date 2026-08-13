package com.pandus.leetcode.solutions.google;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        int remove = k;
        for (char c : num.toCharArray()) {
            while (remove > 0 && !sb.isEmpty() && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                remove--;
            }
            sb.append(c);
        }
        sb.setLength(sb.length() - remove);
        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }
        String res = sb.substring(i);
        return res.isEmpty() ? "0" : res;
    }
}
