package smart.java.concurrent;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/10/2714:44
 */
public class JoinDemo {
    public volatile static int i = 0;

    public static class JoinThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) ;
        }
    }

    public static void main(String[] args) throws Exception {
        JoinThread joinThread = new JoinThread();
        joinThread.start();
        joinThread.join();
        System.out.println(i);
    }
}
