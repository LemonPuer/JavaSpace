package arrayTest;

/**
 * @author Lemon
 * @create 2023-05-07-14:39
 */
public class EChaTree {
    public static void main(String[] args) {
        TreeNode tn1 = new TreeNode(1);
        Tree tree = new Tree(tn1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
        TreeNode tn5 = new TreeNode(5);
        tn1.setLeft(tn2);
        tn1.setRight(tn3);
        tn2.setLeft(new TreeNode(6));
        tn3.setLeft(tn5);
        tn3.setRight(tn4);
//        tree.pre();
//        System.out.println("===========");
//        tree.mid();
//        System.out.println("===========");
//        tree.post();
//        System.out.println(tree.root.preFind(5));
//        System.out.println(tree.root.midFind(5));
//        System.out.println(tree.root.postFind(5));
        tree.difficultDelete(1);
        tree.pre();
    }

}

class Tree {
    public TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
    }

    public void pre() {
        if (this.root != null)
            root.preErgodic();
    }

    public void mid() {
        if (this.root != null)
            root.midErgodic();
    }

    public void post() {
        if (this.root != null)
            root.postErgodic();
    }

    public void easyDelete(int no) {
        if(root==null){
            return;
        }
        if(root.getNo()==no){
            root=null;
            return;
        }
        root.ed(no);
    }

    public void difficultDelete(int no) {
        if (root == null) {
            return;
        }
        if(root.getNo()==no){
            if(root.getLeft()!=null) {
                TreeNode next = root.findNext(root.getLeft());
                next.setRight(root.getRight());
                root = next;
            }else
                root=root.getRight();
        }
        root.dD(no);
    }
}

class TreeNode {
    private int no;
    private TreeNode left;
    private TreeNode right;
    public int leftType=0;//线性化树的标识
    public int rightType=0;

    public TreeNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }

    public void preErgodic() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preErgodic();
        }
        if (this.right != null)
            this.right.preErgodic();
    }

    public void midErgodic() {
        if (this.left != null) {
            this.left.midErgodic();
        }
        System.out.println(this);
        if (this.right != null)
            this.right.midErgodic();
    }

    public void postErgodic() {
        if (this.left != null) {
            this.left.postErgodic();
        }
        if (this.right != null)
            this.right.postErgodic();
        System.out.println(this);
    }

    public TreeNode preFind(int no) {
        System.out.println("!!!");
        if (this.no == no)
            return this;
        TreeNode tn = null;
        if (this.left != null) {
            tn = this.left.preFind(no);
        }
        if (tn != null) {
            return tn;
        }
        if (this.right != null) {
            tn = this.right.preFind(no);
        }
        return tn;
    }

    public TreeNode midFind(int no) {
        TreeNode tn = null;
        if (this.left != null) {
            tn = this.left.midFind(no);
        }
        if (tn != null) {
            return tn;
        }
        System.out.println("!!!");
        if (this.no == no)//因为只有这里是真正的比较，所以从这里计算次数
            return this;
        if (this.right != null) {
            tn = this.right.midFind(no);
        }
        return tn;
    }

    public TreeNode postFind(int no) {
        TreeNode tn = null;
        if (this.left != null) {
            tn = this.left.postFind(no);
        }
        if (tn != null) {
            return tn;
        }
        if (this.right != null) {
            tn = this.right.postFind(no);
        }
        if (tn != null) {
            return tn;
        }
        System.out.println("!!!");
        if (this.no == no)
            return this;
        return null;
    }

    public void ed(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        if (this.left != null)
            this.left.ed(no);
        if (this.right != null)
            this.right.ed(no);
    }
    public void dD(int no){
        if(this.left!=null&&this.left.no==no){
            if(this.left.left!=null&&this.left.right!=null){
                TreeNode node=findNext(this.left.left);
                node.right=this.left.right;
                this.left=this.left.left;
            }else if(this.left.left!=null){
                this.left=this.left.left;
            }else if(this.left.right!=null){
                this.left=this.left.right;
            }else
                this.left=null;
            return;
        }
        if(this.right!=null&&this.right.no==no){
            if(this.right.left!=null&&this.right.right!=null){
                TreeNode node=findNext(this.right.left);
                node.right=this.right.right;
                this.right=this.right.left;
            }else if(this.right.left!=null){
                this.right=this.right.left;
            }else if(this.right.right!=null){
                this.right=this.right.right;
            }else
                this.right=null;
            return;
        }
        if(this.left!=null)
            this.left.dD(no);
        if(this.right!=null)
            this.right.dD(no);
    }
    public TreeNode findNext(TreeNode node){
        if(node.right==null){
            return node;
        }else
            return findNext(node.right);
    }
}