package smart.java.concurrent;

/**
 * @author liujunhua
 * @description: TODO
 * @date 2020/10/3014:50
 */

public class WNDemo {
    final static Object obj = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ":T1 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for obj!");
                    obj.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end!");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {
                System.out.println(System.currentTimeMillis() + ":T2 start!");
                try {
                    System.out.println(System.currentTimeMillis() + ":T2 wait for obj!");
                    obj.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T2 end!");
            }
        }
    }

    public static class T3 extends Thread {
        @Override
        public void run() {
            synchronized (obj) {

                System.out.println(System.currentTimeMillis() + ":T3 start! notify one thread");
                try {
                    Thread.sleep(2000);
                    //obj.notify();
                    obj.notify();
                    obj.notify();
                    //obj.notifyAll();
                    System.out.println(System.currentTimeMillis() + ":T3 end!");

                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1=new T1();
        Thread t2=new T2();
        t1.start();
        t2.start();
        Thread t3=new T3();
        //Thread t4=new T3();
        t3.start();
        //t4.start();
    }
}
