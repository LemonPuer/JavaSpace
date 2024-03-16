package EChaTree;


/**
 * @author Lemon
 * @create 2023-05-19-10:56
 */
public class EChaTree {
    TreeNode root;

    public static void main(String[] args) {
        int[] arr = new int[]{7, 3, 10, 12, 5, 1, 2};
        EChaTree et = new EChaTree();
        for (int i : arr) {
            et.addNode(i);
        }
        et.midOut();
        System.out.println();
        et.delete(1);
        et.midOut();
    }

    public void delete(int val) {
        if (root == null) {
            return;
        }
        TreeNode node = root.find(val);
        //没找到要删除的节点
        if (node == null) {
            return;
        }
        //情况1：删除的节点没有父节点(根节点)
        TreeNode parent = root.parent(val);
        if (parent == null) {
            //需要从右子树选择最小的节点代替
            TreeNode minNode = root.right.minNode();
            parent = root.parent(minNode.val);
            parent.left = null;
            minNode.right = root.right;
            minNode.left = root.left;
            root = minNode;
            return;
        }
        //情况2：删除的节点是叶子节点
        if (node.left == null && node.right == null) {
            if (parent.left == node) {
                parent.left = null;
            } else if (parent.right == node)
                parent.right = null;
            return;
        }
        //情况3：删除的节点有父子节点
        if (parent.left == node) {
            //只有左子树
            if(node.right==null){
                parent.left=node.left;
                return;
            }
            TreeNode minNode = node.right.minNode();
            TreeNode parent1 = root.parent(minNode.val);
            if(node.right==minNode){
                node.right=null;
            }else
                parent1.left=null;
            minNode.right=node.right;
            minNode.left=node.left;
            parent.left=minNode;
        }else{
            //只有左子树
            if(node.right==null){
                parent.left=node.left;
                return;
            }
            TreeNode minNode = node.right.minNode();
            TreeNode parent1 = root.parent(minNode.val);
            if(node.right==minNode){
                node.right=null;
            }else
                parent1.left=null;
            minNode.right=node.right;
            minNode.left=node.left;
            parent.right=minNode;
        }
    }

    public void midOut() {
        if (root == null) {
            System.out.println("null");
            return;
        }
        root.mid();
    }

    public void addNode(int val) {
        TreeNode tn = new TreeNode(val);
        if (root == null) {
            root = tn;
            return;
        }
        root.add(tn);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    //查找最小节点
    public TreeNode minNode() {
        if (this.left != null) {
            return this.left.minNode();
        } else
            return this;
    }

    //查找需要删除节点的父节点
    public TreeNode parent(int val) {
        if (this.left != null && this.left.val == val || this.right != null && this.right.val == val) {
            return this;
        }
        if (this.val > val && this.left != null) {
            return this.left.parent(val);
        } else if (this.val <= val && this.right != null) {
            return this.right.parent(val);
        } else
            return null;
    }

    //查找需要删除的节点
    public TreeNode find(int val) {
        if (this.val == val) {
            return this;
        }
        if (this.left != null && this.val > val) {
            return this.left.find(val);
        } else if (this.right != null && this.val <= val) {
            return this.right.find(val);
        } else
            return null;
    }

    public void add(TreeNode node) {
        if (node == null)
            return;
        if (this.val >= node.val) {
            if (this.left != null)
                this.left.add(node);
            else
                this.left = node;
        } else {
            if (this.right != null)
                this.right.add(node);
            else
                this.right = node;
        }
    }

    public void mid() {
        if (this.left != null) {
            this.left.mid();
        }
        System.out.print(this.val + "  ");
        if (this.right != null) {
            this.right.mid();
        }
    }
}