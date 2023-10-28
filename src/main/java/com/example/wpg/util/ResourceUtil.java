package com.example.wpg.util;

import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;

public class ResourceUtil {

    private InputStream getFileAsIOStream(final String fileName) {
        InputStream ioStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(fileName);

        if (ioStream == null) {
            throw new IllegalArgumentException(fileName + " is not found");
        }
        return ioStream;
    }

    private void printFileContent(InputStream is) throws IOException {
        try (InputStreamReader isr = new InputStreamReader(is);
             BufferedReader br = new BufferedReader(isr);) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            is.close();
        }
    }

    public static void main(final String[] args) throws IOException {
        ResourceUtil instance = new ResourceUtil();
        InputStream is = instance.getFileAsIOStream("demo.txt");
        instance.printFileContent(is);

        System.out.println("========================================================");

        File file = ResourceUtils.getFile("classpath:demo.txt");
        System.out.println("File Found : " + file.exists());
        String content = new String(Files.readAllBytes(file.toPath()));
        System.out.println(content);
    }
}
