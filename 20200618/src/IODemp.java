import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IODemp {
    public static void main(String[] args) {

    }
    private static void copyFile() {
        try (FileReader fileReader = new FileReader("d:/javacode/Aaa.class");
             FileWriter fileWriter = new FileWriter("d:/javacode/Aaa2.class")) {
            int len = -1;
            char[] buffer = new char[1024];
            while ((len = fileReader.read(buffer)) != -1) {
                fileWriter.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
