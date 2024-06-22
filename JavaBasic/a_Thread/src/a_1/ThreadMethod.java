package a_1;

/**
 * 多线程Thread的内部方法
 * @author Lemon
 * @create 2022-08-30-14:16
 */
public class ThreadMethod {
    public static void main(String[] args) {
        Windows a=new Windows();
        a.setName("线程一：");
        Windows b=new Windows();
        b.setName("线程二：");
        a.start();
        System.out.println(a.getPriority());
        b.setPriority(8);
        b.start();
//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){
//            e.printStackTrace();
//        }
        Thread.currentThread().setName("主线程：");
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"卖出第"+i+"张票");
            if(i==5){
                try{
                    a.join();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        System.out.println(a.isAlive());
        System.out.println(b.isAlive());
        //方式二的检测
        Windows1 c=new Windows1();
        Thread d=new Thread(c);
        Thread e=new Thread(c);
        d.setName("线程三：");
        e.setName("线程四：");
        d.start();
        e.start();
    }
}

/**
 *多线程创建方式一
 * @author: Lemon
 * @create:2022/8/30-22:16
*/
class Windows extends Thread{
    private static int a=10;

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(currentThread().getName()+"卖出第"+i+"张票");
            a--;
        }
    }
}
/**
 *多线程创建方式二
 * @author: Lemon
 * @create:2022/8/30-22:19
*/
class Windows1 implements Runnable{
    private int a=10;
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"卖出第"+i+"张票");
            a--;
        }
    }
}