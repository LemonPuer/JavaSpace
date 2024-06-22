package domain;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/02 16:21:59
 */
public abstract class Pizza {
    public String name;

    public void prepare() {
        System.out.println("准备制作" + name);
    }

    public void bake() {
        System.out.println("烘焙" + name);
    }

    public void cut() {
        System.out.println("切割" + name);
    }

    public void box() {
        System.out.println("打包" + name);
    }
}
