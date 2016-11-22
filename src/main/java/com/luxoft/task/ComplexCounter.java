package com.luxoft.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tigra on 22.11.2016.
 */
public class ComplexCounter {

    Map<ComplexKey, Integer> map = new HashMap<>();

    public void count(String[] words) {
        for(String word: words) {
            int[] chars = word.toUpperCase().chars().filter(p -> Vowels.isItVowel(p)).toArray();
            ComplexKey complexKey = new ComplexKey((char[])chars, word.length());
        }
    }

    class ComplexKey {
        char[] chars;
        int lenght;

        ComplexKey(char[] chars, int lenght) {
            this.chars = chars;
            this.lenght = lenght;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{")
                    .append(chars)
                    .append("}")
                    .append(",")
                    .append(lenght);
            return builder.toString();
        }
    }
}
