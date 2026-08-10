package com.pandus.leetcode.solutions.google;

import java.util.ArrayList;
import java.util.List;

public class DecodeString {

    private int i = 0;

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;

        StringBuilder kSb = new StringBuilder();
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == ']') {
                i++;
                return sb.toString();
            } else if (Character.isDigit(c)) {
                kSb.append(c);
                i++;
            } else if (c == '[') {
                i++;
                String inner = decodeString(s);
                k = Integer.parseInt(kSb.toString());
                sb.append(inner.repeat(Math.max(0, k)));
                k = 0;
                kSb = new StringBuilder();
            } else {
                sb.append(c);
                i++;
            }
        }
        return sb.toString();
    }

    // private int i = 0;              // общий курсор
    //
    //decode(s):
    //    sb = new StringBuilder()
    //    k = 0
    //    пока i < s.length():
    //        c = s.charAt(i)
    //        если c == ']':
    //            i++                 // съедаем ']' и закрываем блок
    //            вернуть sb.toString()
    //        иначе если c — цифра:
    //            k = ?               // ВОПРОС 1
    //            i++
    //        иначе если c == '[':
    //            i++                 // съедаем '['
    //            inner = decode(s)   // рекурсия разберёт вложенный блок
    //            дописать inner в sb ровно k раз
    //            k = ?               // ВОПРОС 2
    //        иначе:                  // обычная буква
    //            sb.append(c)
    //            i++
    //    вернуть sb.toString()
}
