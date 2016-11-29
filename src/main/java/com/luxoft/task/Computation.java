package com.luxoft.task;

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
      counter.count(word);
    }
    System.out.println(counter.getMap());
  }
}
