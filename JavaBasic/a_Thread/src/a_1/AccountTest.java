package a_1;

/**
 * 银行有一个账户。
 * 有两个储户分别向同一个账户存3000元，每次存1000，存3次。每次存完打印账户余额。
 * 问题：该程序是否有安全问题，如果有，如何解决？
 *
 * @author Lemon
 * @create 2022-09-01-10:40
 */
public class AccountTest {

    public static void main(String[] args) {
        Account a = new Account();
        Thread b = new Thread(a);
        Thread c = new Thread(a);
        b.setName("线程一：");
        c.setName("线程二：");
        b.start();
        c.start();
    }
}

class Account implements Runnable {
    private double account = 3000;
    private double add = 1000;

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (this) {
                addAccount();
                System.out.println(Thread.currentThread().getName() + "余额：" + account);
            }
        }
    }

    private double addAccount() {
        account += add;
        return account;
    }
}