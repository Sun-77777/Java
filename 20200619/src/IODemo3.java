import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class IODemo3 {
    public static void main(String[] args) throws IOException {
        copyFile("d:/javacode/Aaa.java","d:/javacode/Aaa2.java");
    }

    /**
     * 第一次改：存在文件资源泄露问题
     *  出现异常，没有处理，Java JVM 会把程序终止，导致close方法没有被调用，但是文件被打开了。用try catch解决
     * 第二次改：空指针异常
     *  如果文件打开失败了，也就是路径错误，此时并没有打开文件创建对象，但是文件的close方法还是会被调用，所以发生空指针异常
     *      解决办法：  再一次进行判断，对象是否为空   fileInputStream != null  fileOutputStream != null
     * 第三次改：代码不够好看
     *     解决办法： 把创建对象放在try 括号里
     * @param srcPath
     * @param descPath
     * @throws IOException
     */
    public static void copyFile(String srcPath,String descPath) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(descPath);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static void copeFile2() throws FileNotFoundException {
        //当代码写成这个样子的时候，就不需要显示调用close了
        //try语句会在代码执行完毕后，自动调用close方法（前提是这个类必须要实现Closable 接口）
        try (FileInputStream fileInputStream = new FileInputStream("d:/javacode/Aaa.java");
             FileOutputStream fileOutputStream = new FileOutputStream("d:/javacode/Aaa2.java")){
            byte[] buffer = new byte[1024];
            int len = -1;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
