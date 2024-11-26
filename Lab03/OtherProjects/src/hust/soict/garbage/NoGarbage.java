package hust.soict.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {

    public static void main(String[] args) {
        String filename = "C:\\Users\\ACER\\OneDrive - Hanoi University of Science and Technology\\Desktop\\TH OOP\\Lab03\\OtherProject\\hust\\soict\\dsai\\garbage\\test.txt";
        byte[] inputBytes;
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            StringBuffer outputString = new StringBuffer();
            for (byte b : inputBytes) {
                outputString.append((char) b);
            }
            endTime = System.currentTimeMillis();
            System.out.println("Time taken to concatenate using StringBuffer: " + (endTime - startTime) + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}