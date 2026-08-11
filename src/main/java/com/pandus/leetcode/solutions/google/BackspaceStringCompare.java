package com.pandus.leetcode.solutions.google;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int counter = 0;
        StringBuilder sb1 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '#') {
                counter++;
                continue;
            } else if (counter > 0) {
                counter--;
                continue;
            }
            sb1.append(s.charAt(i));
        }

        StringBuilder sb2 = new StringBuilder();
        counter = 0;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (t.charAt(i) == '#') {
                counter++;
                continue;
            } else if (counter > 0) {
                counter--;
                continue;
            }
            sb2.append(t.charAt(i));
        }
        return sb1.toString().equals(sb2.toString());
    }
}
