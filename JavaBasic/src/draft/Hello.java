package draft;

public class Hello {
    public static void main(String[] args) {
        A a = new A();
        Thread t = new Thread(a);
        t.start();

//        A a = new A();
//        a.start();
//
//        A a = new A();
//        FutureTask f = new FutureTask(a);
//        new Thread(f).start();
//        try {
//            Object o = f.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
//
//        Test a = new Test();
//        System.out.println("hello");
//        a.start();
//        for (int i = 0; i < 100; i++) {
//            if (i % 2 != 0) {
//                System.out.println("main()");
//            }
//        }
    }
}

/**
 * 多线程的创建方式一
 */
class draft_test extends Thread {
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}

//class A implements Callable {
//    public Object call() throws Exception {
//        return null;
//    }
//}
//class A extends Thread{
//    public void run() {
//        //操作声明
//    }
//}
class A implements Runnable {
    public void run() {
    }
}