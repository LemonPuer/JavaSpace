package a_1;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，店员一次
 * 只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员会叫生产者停一下，如
 * 店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者等一下，如
 * 果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 * 生产者比消费者快时，消费者会漏掉一些数据没有取到。
 * 消费者比生产者快时，消费者会取相同的数据。
 *
 * @author Lemon
 * @create 2022-09-01-11:41
 */
public class ProductTest {
    public static void main(String[] args) {
        Clerk a = new Clerk();
        //Thread
//        Productor p1 = new Productor(a);
//        Customer c1 = new Customer(a);
//        p1.setName("线程1：");
//        c1.setName("线程2：");
//        p1.start();
//        c1.start();
        //Runnable
        Thread p2 = new Thread(new Productor1(a));
        Thread c2 = new Thread(new Customer(a));
        p2.setName("线程3：");
        c2.setName("线程4：");
        p2.start();
        c2.start();
    }
}

class Productor extends Thread {
    private Clerk a = new Clerk();

    public Productor(Clerk a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            a.addProduction();
        }
    }
}

class Clerk {
    public int production = 0;

    //生产商品
    public synchronized void addProduction() {
        if (production < 20) {
            production++;
            System.out.println(Thread.currentThread().getName() + "生产了：" + production);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //卖出商品
    public synchronized void minusProduction() {
        if (production > 0) {
            System.out.println(Thread.currentThread().getName() + "剩余：" + production);
            production--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Customer extends Thread {
    private Clerk a = new Clerk();

    public Customer(Clerk a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            a.minusProduction();
        }
    }
}

class Productor1 implements Runnable {
    private Clerk a = new Clerk();

    public Productor1(Clerk a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            a.addProduction();
        }
    }
}

class Customer1 implements Runnable {
    private Clerk a = new Clerk();

    public Customer1(Clerk a) {
        this.a = a;
    }

    public void run() {
        while (true) {
            a.minusProduction();
        }
    }
}