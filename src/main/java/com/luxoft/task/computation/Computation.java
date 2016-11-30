package com.luxoft.task.computation;

import com.luxoft.task.JobCounter;

import java.util.Map;

/**
 *
 * Created by mironova on 11/29/2016.
 */
public class Computation {

  private byte[] data;

  public Computation(byte[] data) {
    this.data = data;
  }

  public void run() {
    if (data == null) throw new IllegalStateException("data cant be null!");
    String[] list = new String(data).split(" ");
    JobCounter counter = new JobCounter();
    for(String word: list) {
      String clearWord = word.replaceAll("[^A-Za-z0-9]", "");
      System.out.println(clearWord);
      counter.count(clearWord);
    }

    for(Map.Entry<ComplexKey, ComplexState> entry: counter.getMap().entrySet()) {
      StringBuilder builder = new StringBuilder();
      builder.append(entry.getKey().getChars())
              .append(" ")
              .append(entry.getKey().getLenght())
              .append("->")
              .append(entry.getValue().getAverage());
      System.out.println(builder.toString());
    }
  }
}
