package Java_0625;

import java.io.*;

public class IODemo1 {
    public static void main(String[] args) {
        copyFiles2();
    }

    private static void copyFiles() {
        try (FileReader fileReader = new FileReader("d:/A/aaa.txt");
             FileWriter fileWriter = new FileWriter("d:/A/aaa2.txt")){
            char[] buffer = new char[1024];
            int len = -1;
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFiles1() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/A/aaa.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/A/aaa2.txt"))){
            int len = -1;
            char[] buffer = new char[1024];
            while ((len = bufferedReader.read(buffer)) != -1) {
                bufferedWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void copyFiles2() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("d:/A/aaa2.txt"));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("d:/A/aaa.txt"))){
            String line = " ";
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("line:" + line);
                bufferedWriter.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
