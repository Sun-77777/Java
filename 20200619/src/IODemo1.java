import java.io.File;

public class IODemo1 {
    public static void main(String[] args) {
        File file = new File("d:/A");
        list(file);
        /*for (File f : files) {
            System.out.println(f);
        }*/
    }
    public static void list(File file) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                list(f);
            } else {
                System.out.println(f);
            }
        }
    }
}
