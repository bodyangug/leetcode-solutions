package com.pandus.leetcode.solutions.google;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int multiply = n1 * n2;
                result[i + j + 1] += multiply;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = (n + m) - 1; i >= 0; i--) {
            int digit = result[i] % 10;
            int carry = result[i] / 10;
            if (i > 0) {
                result[i - 1] += carry;
            }
            sb.append(digit);
        }
        sb.reverse();
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
