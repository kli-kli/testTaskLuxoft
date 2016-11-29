package com.luxoft.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by mironova on 11/29/2016.
 */
public class LoadData {

  public static byte[] getData(Path path) {
    byte[] data = null;
    try {
      data = Files.readAllBytes(path);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return data;
  }
}
