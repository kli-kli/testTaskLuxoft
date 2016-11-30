package com.luxoft.task;

import com.luxoft.task.computation.ComplexKey;
import com.luxoft.task.computation.ComplexState;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 *
 * Created by Tigra on 22.11.2016.
 */
public class JobCounter {

  private Map<ComplexKey, ComplexState> map = new HashMap<>();

  public void count(String word) {
    int[] charsInt = word.toUpperCase().chars().filter(p -> Vowels.isItVowel((char)p)).toArray();
    int length = charsInt.length;
    char[] chars = IntStream.of(charsInt).mapToObj(c -> Character.toString((char) c))
        .distinct()
        .sorted()
        .collect(Collectors.joining()).toCharArray();

    ComplexKey key = new ComplexKey(chars, word.length());
    if (map.containsKey(key)) {
      ComplexState state = map.get(key);
      state.addNewWord(length);
    } else {
      map.put(key, new ComplexState(1, length));
    }
  }

  public Map<ComplexKey, ComplexState> getMap() {
    return map;
  }
}
