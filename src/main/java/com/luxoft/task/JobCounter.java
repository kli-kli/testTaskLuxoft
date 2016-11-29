package com.luxoft.task;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * Created by Tigra on 22.11.2016.
 */
public class JobCounter {

  private Map<ComplexKey, ComplexState> map = new HashMap<>();

  public void count(String word) {
    int[] charsInt = word.toUpperCase().chars().filter(p -> Vowels.isItVowel(p)).toArray();
    char[] chars = IntStream.of(charsInt).mapToObj(c -> Character.toString((char) c))
        .collect(Collectors.joining()).toCharArray();
    ComplexKey key = new ComplexKey(chars, word.length());
    if (map.containsKey(key)) {
      ComplexState state = map.get(key);
      state.addNewWord(chars.length);
    } else {
      map.put(key, new ComplexState(1, chars.length));
    }
  }

  public Map<ComplexKey, ComplexState> getMap() {
    return map;
  }
}
