package com.luxoft.task;

/**
 * Created by mironova on 11/29/2016.
 */
public class ComplexKey {

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
