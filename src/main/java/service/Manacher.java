package service;

import java.util.Arrays;

public class Manacher {
    private String str;

    public Manacher(String str) {
        this.str = str;
    }

    public String findLongestPalindrome() {
        if (str == null || str.length() == 0) {
            return "";
        }

        char[] word = addBoundaries(str.toCharArray());
        int[] radius = new int[word.length];
        int center = 0,
                right = 0;
        int m, n = 0;

        for (int i = 1; i < word.length; i++) {
            if (i > right) {
                radius[i] = 0;
                m = i - 1;
                n = i + 1;
            } else {
                int index = center * 2 - i;
                if (radius[index] < (right - i)) {
                    radius[i] = radius[index];
                    m = -1;
                } else {
                    radius[i] = right - i;
                    n = right + 1;
                    m = i * 2 - n;
                }
            }

            while (m >= 0 && n < word.length && word[m] == word[n]) {
                radius[i]++;
                m--;
                n++;
            }

            if ((i + radius[i]) > right) {
                center = i;
                right = i + radius[i];
            }
        }

        int length = 0;
        center = 0;
        for (int i = 1; i < word.length; i++) {
            if (length < radius[i]) {
                length = radius[i];
                center = i;
            }
        }

        char[] result = Arrays.copyOfRange(word, center - length, center + length + 1);
        return String.valueOf(removeBoundaries(result));
    }

    private char[] addBoundaries(char[] elem) {
        if (elem == null || elem.length == 0) {
            return "||".toCharArray();
        }

        char[] word = new char[elem.length * 2 + 1];
        for (int i = 0; i < (word.length - 1); i += 2) {
            word[i] = '|';
            word[i + 1] = elem[i / 2];
        }

        word[word.length - 1] = '|';
        return word;
    }

    private char[] removeBoundaries(char[] elem) {
        if (elem == null|| elem.length == 0) {
            return "".toCharArray();
        }

        char[] word = new char[(elem.length) / 2];

        for (int i = 0; i < word.length; i++) {
            word[i] = elem[i * 2 + 1];
        }

        return word;
    }
}
