package arrayTest;


/**
 * @author Lemon
 * @create 2023-05-12-11:58
 */
public class XSTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(6);
        TreeNode n4 = new TreeNode(8);
        TreeNode n5 = new TreeNode(10);
        TreeNode n6 = new TreeNode(14);
        n1.setRight(n3);
        n1.setLeft(n2);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n1.postErgodic();
        NewTN newTN = new NewTN(n1);
        System.out.println("============");
        newTN.midXSH(n1);
        newTN.postOut(n1);
    }
}

class NewTN {
    private TreeNode root;
    private TreeNode pre;

    public NewTN(TreeNode root) {
        this.root = root;
        pre = null;
    }

    //前序线性化
    public void preXSH(TreeNode node) {
        if (node == null)
            return;
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.leftType = 1;
        }
        if (pre != null && pre.getRight() == null && pre.getLeft() != node) {
            pre.setRight(node);
            pre.rightType = 1;
        }
        pre = node;
        //因为先修改了前驱节点，所以要防止进入死循环
        if (node.leftType == 0)
            preXSH(node.getLeft());
        if (node.leftType == 0)//此处判断可以省略
            preXSH((node.getRight()));
    }

    //中序线性化
    public void midXSH(TreeNode node) {
        if (node == null)
            return;
        //
        midXSH(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.leftType = 1;
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.rightType = 1;
        }
        pre = node;
        midXSH(node.getRight());
    }

    //后序线性化
    public void postXSH(TreeNode node) {
        if (node == null)
            return;
        postXSH(node.getLeft());
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.leftType = 1;
        }
        postXSH(node.getRight());
        if (pre != null && pre.getRight() == null && pre != node) {
            pre.setRight(node);
            pre.rightType = 1;
        }
        pre = node;
    }

    //前序遍历
    public void preOut(TreeNode node) {
        System.out.println(node);
        if (node.leftType == 0 && node.getLeft() != null)
            preOut(node.getLeft());
        if (node.rightType == 0 && node.getRight() != null)
            preOut(node.getRight());
    }

    //中序遍历
    public void midOut(TreeNode node) {
        while (node != null) {
            while (node.leftType == 0)
                node = node.getLeft();
            System.out.println(node);
            while(node.rightType==1){
                node=node.getRight();
                System.out.println(node);
            }
            node=node.getRight();
        }
    }

    //后序遍历
    public void postOut(TreeNode node) {
        if (node.leftType == 0 && node.getLeft() != null)
            postOut(node.getLeft());
        if (node.rightType == 0 && node.getRight() != null)
            postOut(node.getRight());
        System.out.println(node);
    }
}
