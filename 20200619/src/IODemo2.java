import java.io.*;
import java.util.Scanner;

public class IODemo2 {
    public static void main(String[] args) throws IOException {
        copeFile();
    }

    private static void copeFile() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/javacode/Bbb.java"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/javacode/Bbb2.java"));

        //这就是一个缓冲区，只不过这个是在代码中由程序猿手动创建的缓冲区和buffered 对象的内置缓冲是两回事
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer,0,length);
        }
        //此处实际到四个流对象
        //此处不需要写四次关闭
        //调用这一组close 就会自动关闭内部包含的FileInputStream
        bufferedInputStream.close();
        bufferedOutputStream.close();

    }
    private static void copyFile2() {
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("d:/javacode/Bbb.java"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("d:/javacode/Bbb.java"))){
            int len = -1;
            byte[] buffer = new byte[1024];
            while ((len = bufferedInputStream.read(buffer)) != -1) {
                bufferedOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
