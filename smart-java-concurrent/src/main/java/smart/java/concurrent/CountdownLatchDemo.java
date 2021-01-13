package smart.java.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liujunhua
 * @date 2020/12/1715:17
 *
 * @description:
 * 倒计数器：CountDownLatch
 * 通常用来控制线程等待，让某一个线程等待直到倒计数结束，再开始执行
 *
 * 场景：
 * 1. 火箭发射
 */
public class CountdownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        demo2();
    }

    private static void demo2() throws InterruptedException {
        final CountDownLatch cdAnswer = new CountDownLatch(2);

        System.out.println("cdAnswer1完成");
        cdAnswer.countDown();

       /* System.out.println("cdAnswer2完成");
        cdAnswer.countDown();*/

        cdAnswer.await();

        System.out.println("全部完成");
    }

    private void demo1() throws InterruptedException {
        final CountDownLatch cdOrder = new CountDownLatch(1);
        final CountDownLatch cdAnswer = new CountDownLatch(3);
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            try {
                //cdOrder.await();
                System.out.println("cdAnswer1完成");
                cdAnswer.countDown();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        service.execute(() -> {
            try {
                //cdOrder.await();
                //cdOrder.await();
                System.out.println("cdAnswer2完成");
                cdAnswer.countDown();

            } catch (Exception e) {
                e.printStackTrace();
            }

        });

        cdOrder.countDown();
        cdAnswer.await();
        System.out.println("cdOrder2完成");
    }
}
