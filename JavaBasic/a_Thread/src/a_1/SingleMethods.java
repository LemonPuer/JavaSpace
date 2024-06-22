package a_1;

/**
 * 单例模式线程安全的懒汉模式
 *
 * @author: Lemon
 * @create:2022/9/1-15:47
 */
public class SingleMethods {
    private static SingleMethods sin = null;

    private SingleMethods() {

    }

    //同步方法
//    public static synchronized SingleMethods getSingleMods() {
//        if (sin == null) {
//            sin = new SingleMethods();
//        }
//        return sin;
//    }
//同步代码块
    public static SingleMethods getSingleMods() {
//        synchronized(SingleMethods.class){
//            if (sin == null) {
//                sin = new SingleMethods();
//            }
//            return sin;
//        }
//效率更高
        if (sin == null) {
            synchronized (SingleMethods.class) {
                if(sin==null){
                    sin = new SingleMethods();
                }
            }
        }
        return sin;
    }
}