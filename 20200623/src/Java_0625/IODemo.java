package Java_0625;

import java.io.*;

public class IODemo {
    public static void main(String[] agrs) {
        //testNoBuffer();
        testBuffer();
    }

    private static void testBuffer() {
        long beg = System.currentTimeMillis();
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/555555.txt"));
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/5555552.txt"))){

            int ch = -1;
            while ((ch = bufferedInputStream.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-beg + "ms");
    }

    private static void testNoBuffer() {
        long beg = System.currentTimeMillis();
        try (FileInputStream fileInputStream = new FileInputStream("d:/555555.txt");
             FileOutputStream fileOutputStream = new FileOutputStream("d:/5555552.txt")){

            int ch = -1;
            while ((ch = fileInputStream.read()) != -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-beg + "ms");
    }


}
