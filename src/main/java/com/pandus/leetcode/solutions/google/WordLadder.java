package com.pandus.leetcode.solutions.google;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.List;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        ArrayDeque<String> deque = new ArrayDeque<>();
        deque.add(beginWord);
        dict.remove(beginWord);
        int level = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String word = deque.poll();
                char[] wordArray = word.toCharArray();
                if (word.equals(endWord)) return level;
                for (int j = 0; j < word.length(); j++) {
                    char currentChar = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String candidate = new String(wordArray);
                        if (dict.contains(candidate)) {
                            dict.remove(candidate);
                            deque.offer(candidate);
                        }
                        wordArray[j] = currentChar;
                    }
                }
            }
            level++;
        }
        return 0;
    }

}
