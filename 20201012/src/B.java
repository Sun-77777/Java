import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class B {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int buy = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int price = scanner.nextInt();
        int c_size = price/100;
        int ret = 0;
        while (buy > 0) {
            if (c_size <= c) {
                count += c_size;
                if (price%100 != 0) {
                    count = count + 1;
                    ret = count*100-price;
                    b += ret/50;
                    a += (ret%50)/10;
                    ret = 0;
                }
                c -= c_size;
            } else {
                count += c;
                int cur_price = price - 100*c;
                int b_size = cur_price/50;
                if (b_size <= b) {
                    count += b_size;
                    if (cur_price%50 != 0) {
                        count = count + 1;
                        ret = count*50 - cur_price;
                        a += ret/10;
                    }
                } else {
                    int aa_price = cur_price - 50*b;
                    int a_size = aa_price/10;
                    count += a_size;
                }
            }
            buy--;
        }
        System.out.println(count);
    }
}
