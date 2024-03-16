package AVL;

/**
 * @author Lemon
 * @create 2023-05-20-10:17
 */
public class AVLTree {
    Node root;

    public static void main(String[] args) {
        //左旋转
//        int[] arr=new int[]{4,3,6,5,7,8};
        //右旋转
//        int[] arr = new int[]{10, 12, 8, 9, 7, 6};
        //双旋转
        int[] arr = new int[]{10, 11, 7, 6, 8, 9};
        AVLTree at = new AVLTree();
        for (int i : arr) {
            at.addNode(i);
        }
        at.midOut();
        System.out.println();
        System.out.println(at.root.left.height());
        System.out.println(at.root.right.height());
    }

    public void delete(int val) {
        if (root == null) {
            return;
        }
        Node node = root.find(val);
        //没找到要删除的节点
        if (node == null) {
            return;
        }
        //情况1：删除的节点没有父节点(根节点)
        Node parent = root.parent(val);
        if (parent == null) {
            //需要从右子树选择最小的节点代替
            Node minNode = root.right.minNode();
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
            if (node.right == null) {
                parent.left = node.left;
                return;
            }
            Node minNode = node.right.minNode();
            Node parent1 = root.parent(minNode.val);
            if (node.right == minNode) {
                node.right = null;
            } else
                parent1.left = null;
            minNode.right = node.right;
            minNode.left = node.left;
            parent.left = minNode;
        } else {
            //只有左子树
            if (node.right == null) {
                parent.left = node.left;
                return;
            }
            Node minNode = node.right.minNode();
            Node parent1 = root.parent(minNode.val);
            if (node.right == minNode) {
                node.right = null;
            } else
                parent1.left = null;
            minNode.right = node.right;
            minNode.left = node.left;
            parent.right = minNode;
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
        Node tn = new Node(val);
        if (root == null) {
            root = tn;
            return;
        }
        root.add(tn);
        if (root.right != null && root.left != null && root.left.height() - root.right.height() > 1) {
            //双旋转条件
            if (root.left.right != null && root.left.left != null && root.left.right.height() > root.left.left.height()) {
                root.left.leftRotate();
            }
            root.rightRotate();
            return;
        }
        if (root.right != null && root.left != null && root.right.height() - root.left.height() > 1) {
            //双旋转条件
            if (root.left.right != null && root.left.left != null && root.right.left.height() > root.right.right.height())
                root.right.rightRotate();
            root.leftRotate();
        }
    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }

    //左旋转
    public void leftRotate() {
        Node node = new Node(val);
        node.left = left;
        node.right = right.left;
        val = right.val;
        right = right.right;
        left = node;
    }

    //右旋转
    public void rightRotate() {
        Node node = new Node(val);
        node.right = right;
        node.left = left.right;
        val = left.val;
        left = left.left;
        right = node;
    }

    //返回树的高度
    public int height() {
        return Math.max(left == null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
    }

    //查找最小节点
    public Node minNode() {
        if (this.left != null) {
            return this.left.minNode();
        } else
            return this;
    }

    //查找需要删除节点的父节点
    public Node parent(int val) {
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
    public Node find(int val) {
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

    public void add(Node node) {
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