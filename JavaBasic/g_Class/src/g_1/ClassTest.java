package g_1;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.Random;

/**
 * @author Lemon
 * @create 2022-09-26-20:57
 */
public class ClassTest {
    public static void main(String[] args) {
        //获取一个系统类加载器
        ClassLoader cl = ClassTest.class.getClassLoader();
        System.out.println(cl);
        //获取系统类加载器的父类加载器，即扩展类加载器
        cl = cl.getParent();
        System.out.println(cl);
        //获取扩展类加载器的父类加载器，即引导类加载器
        cl = cl.getParent();
        System.out.println(cl);

        cl = String.class.getClassLoader();
        System.out.println(cl);
    }

    @Test
    public void Test() {
        String path = null;
        for (int i = 0; i < 3; i++) {
            switch (new Random().nextInt(3)) {
                case 0:
                    path = "g_1.Person";
                    break;
                case 1:
                    path = "g_1.ClassTest";
                    break;
                case 2:
                    path = "java.util.Date";
                    break;
            }
            try {
                System.out.println(getInstance(path));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getInstance(String classPath) throws Exception {
        return Class.forName(classPath).newInstance();
    }

    @Test
    public void Test1() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        Field id = clazz.getField("id");
        id.set(p, 1001);
        System.out.println(id.get(p));

        Method country = clazz.getMethod("country", String.class);
        country.invoke(p, "chinese");
        System.out.println(country);

        Constructor<Person> cs = clazz.getConstructor();
        Person p1 = cs.newInstance();
        System.out.println(p1);

    }

    @Test
    public void Test2() throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();
        Field name = clazz.getDeclaredField("name");
        //保证当前属性是可访问的
        name.setAccessible(true);
        name.set(p, "Tom");
        System.out.println(name.get(p));

        Method country = clazz.getDeclaredMethod("country", String.class);
        country.setAccessible(true);
        country.invoke(p, "chinese");
        System.out.println(country);

        Constructor<Person> cs = clazz.getDeclaredConstructor(String.class, int.class, int.class);
        Person p1 = cs.newInstance("jom", 20, 1001);
        System.out.println(p1);
    }

    @Test
    public void Test3() {
        Class<Person> clazz = Person.class;
        Class<? super Person> clazz1 = clazz.getSuperclass();
        System.out.println(clazz1);

        Type type = clazz.getGenericSuperclass();
        System.out.println(type);

        ParameterizedType pt = (ParameterizedType) type;
        Type[] types = pt.getActualTypeArguments();
        System.out.println(types[0].getTypeName());
        System.out.println(((Class) types[0]).getName());

        System.out.println(clazz.getPackage());
    }
}