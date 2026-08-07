package com.pandus.leetcode.solutions.google;

class Reader4 {
    private final String file;
    private int filePtr = 0;

    public Reader4(String file) {
        this.file = file;
    }

    protected int read4(char[] buf4) {
        int count = 0;
        while (count < 4 && filePtr < file.length()) {
            buf4[count++] = file.charAt(filePtr++);
        }
        return count;
    }
}

public class ReadNCharactersGivenReadFourthIICallMultipleTimes extends Reader4 {
    public ReadNCharactersGivenReadFourthIICallMultipleTimes(String file) {
        super(file);
    }

    private char[] buf4 = new char[4];
    private int buf4Ptr = 0;
    private int buf4Count = 0;

    public int read(char[] buf, int n) {
        int written = 0;

        while (written < n) {
            // 1. склад пуст? (buf4Ptr == buf4Count) → buf4Count = read4(buf4), buf4Ptr = 0
            if (buf4Ptr == buf4Count) {
                buf4Count = read4(buf4);
                buf4Ptr = 0;
            }
            // 2. buf4Count == 0? → break (файл кончился)
            if (buf4Count == 0) break;
            // 3. переложить один символ: buf[written] = buf4[buf4Ptr]
            //    сдвинуть buf4Ptr и written
            buf[written] = buf4[buf4Ptr];
            buf4Ptr++;
            written++;
        }

        return written;
    }
}
