package com.luxoft.task.computation;

import java.util.Arrays;

/**
 * Created by mironova on 11/29/2016.
 */
public class ComplexKey {

  private char[] chars;

  private int lenght;

  public ComplexKey(char[] chars, int lenght) {
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

  public char[] getChars() {
    return chars;
  }

  public void setChars(char[] chars) {
    this.chars = chars;
  }

  public int getLenght() {
    return lenght;
  }

  public void setLenght(int lenght) {
    this.lenght = lenght;
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(chars) + Integer.hashCode(lenght);
  }

  @Override
  public boolean equals(Object other) {
    if(!(other instanceof ComplexKey)) {
      return false;
    }

    ComplexKey key = (ComplexKey) other;
    if (!Arrays.equals(this.chars, key.chars)) {
      return false;
    }

    if (this.lenght != key.lenght) {
      return false;
    }

    return true;
  }

}
