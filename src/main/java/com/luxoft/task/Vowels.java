package com.luxoft.task;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by Tigra on 22.11.2016.
 */
public enum Vowels {
    A('A'), E('E'), I('I'), O('O'), U('U');

    private final char ch;

    Vowels(char ch) {
        this.ch = ch;
    }

    char getChar() {
        return ch;
    }

    static boolean isItVowel(int ch) {
        return Arrays.stream(Vowels.values()).anyMatch(p -> p.ch == ch);
    }
}
