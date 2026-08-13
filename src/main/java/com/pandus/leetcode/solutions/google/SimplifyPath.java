package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;
import java.util.Iterator;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] sp = path.split("/");
        ArrayDeque<String> stack = new ArrayDeque<>();
        for (String s : sp) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            } else if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }

        Iterator<String> it = stack.descendingIterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append("/").append(it.next());
        }

        return sb.isEmpty() ? "/" : sb.toString();
    }
}
