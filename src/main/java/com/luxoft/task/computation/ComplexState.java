package com.luxoft.task.computation;

/**
 *
 * Created by mironova on 11/29/2016.
 */
public class ComplexState {


  private int counterWords;
  private int counterVowels;

  public ComplexState(int counterWords, int counterVowels) {
    this.counterWords = counterWords;
    this.counterVowels = counterVowels;
  }

  public void addNewWord(int amount) {
    counterWords ++;
    counterVowels = counterVowels + amount;
  }

  public Double getAverage() {
    return Double.valueOf(counterVowels)/counterWords;
  }
}
