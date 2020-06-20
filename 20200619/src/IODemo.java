import java.io.File;
import java.io.IOException;

public class IODemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/aa.txt");
        System.out.println("文件是否存在" + file.exists());
        System.out.println("文件是否是普通文件" + file.isFile());
        System.out.println("文件是否是目录文件" + file.isDirectory());
        file.createNewFile();
    }
}
