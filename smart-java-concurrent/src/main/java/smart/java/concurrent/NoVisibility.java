package smart.java.concurrent;

/**
 * @author liujunhua
 * @date 2020/12/29 15:48
 * @description: NoVisibility
 */
public class NoVisibility {

    private static volatile boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) ;
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);
    }

}
