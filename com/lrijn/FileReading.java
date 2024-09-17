package com.lrijn;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReading{
    public static String readFile(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            File myFile = new File(filePath);
            Scanner scanner = new Scanner(myFile);

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                fileContent.append(data).append("\n");
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }
}

