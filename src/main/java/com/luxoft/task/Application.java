package com.luxoft.task;

import java.nio.file.Path;
import java.nio.file.Paths;


/**
 *
 * Entry point
 */
public class Application {

    private static Path path = Paths.get("/tmp");

    public static void main(String ...args) {
      byte[] data = LoadData.getData(path);
      Computation computationJob = new Computation(data);
      computationJob.run();
    }
}
