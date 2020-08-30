package exception;

public class OrderSystemException extends Exception{
    public OrderSystemException(String message) {
        System.out.println(message);
    }
}
