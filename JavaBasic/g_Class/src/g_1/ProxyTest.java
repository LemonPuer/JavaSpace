package g_1;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Lemon
 * @create 2022-09-27-21:03
 */
public class ProxyTest {
    @Test
    public void Test() {
        SingStar ss = new SingStar();
        Star pit = (Star) ProxyAgent.getProxyInstance(ss);
        pit.perform();
        People peo = new People();
        Object pit1 = ProxyAgent.getProxyInstance(peo);
        System.out.println(pit);
        System.out.println(pit1);
//        pit1.breath();
    }
}

/*
要想实现动态代理，需要解决的问题？
问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 */
class MIHandler implements InvocationHandler {
    private Object obj;//需要使用被代理类的对象进行赋值

    public void connect(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //obj:被代理类的对象
        return method.invoke(obj, args);
    }
}

class ProxyAgent {
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj) {//obj:被代理类的对象
        MIHandler handler = new MIHandler();

        handler.connect(obj);

        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

interface Star {
    void perform();

}

//被代理类
class SingStar implements Star {
    @Override
    public void perform() {
        System.out.println("歌星会唱歌");
    }
}

interface Creature {
    void breath();
}

class People implements Creature {

    @Override
    public void breath() {
        System.out.println("人类需要呼吸");
    }
}