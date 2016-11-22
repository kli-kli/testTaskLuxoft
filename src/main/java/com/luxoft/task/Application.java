package com.luxoft.task;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


/**
 * Entry point
 */
public class Application {

   // private static final Logger log = LogManager.getLogger(Application.class);
    public static void main(String ...args) {
        Application app = new Application();
        switch (args.length) {
            case 0:
                log.error("wrong parameters!");
            break;
            case 1:
                Path path = FileSystems.getDefault().getPath(args[0]);
                app.run(path);
            break;
            case 2:
                path = FileSystems.getDefault().getPath(args[0]);
                Charset charset = Charset.defaultCharset();
                app.run(path,charset);
            break;
            default:
                log.error("wrong parameters!");
            break;
        }
    }

    public void run(Path path) {
        Charset charset = Charset.defaultCharset();
        run(path, charset);
    }

    public void run(Path path, Charset charset) {
        log.trace("starting read file");
        try (BufferedReader reader = Files.newBufferedReader(path, charset)) {
            log.trace("read new line");
            ComplexCounter counter = new ComplexCounter();
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                counter.count(words);
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
        log.trace("finished read file");
    }
}
