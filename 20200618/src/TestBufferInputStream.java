import java.io.*;

//内置了缓冲区  缓冲区存在的意义是为了提高程序的效率
//程序访问内存比程序访问磁盘要快很多 IO操作肯定涉及到磁盘访问
//IO次数越多，整体的程序效率就越低~
public class TestBufferInputStream {
    public static void main(String[] args) throws FileNotFoundException {
        copyFile();
    }
    private static void copyFile() throws FileNotFoundException {
        //BufferedInputStream
        FileInputStream fileInputStream = new FileInputStream("d:/javacode/Aaa.class");
        FileOutputStream fileOutputStream = new FileOutputStream("d:/javacode/Bbb.class");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
    }
}
