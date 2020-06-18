import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestIODemo {
    public static void main(String[] args) {
        testNoBuffer();
        //testBuffer();
    }

    private static void testBuffer() {
        long beg = System.currentTimeMillis();
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(""))) {
            int ch = -1;
            while ((ch = bufferedInputStream.read())!= -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("buffer: " + (end-beg) + "ms");
    }

    private static void testNoBuffer() {
        long beg = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream("")) {
            int ch = -1;
            while ((ch = fileInputStream.read())!= -1) {

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("nobuffer: " + (end-beg) + "ms");
    }
}
