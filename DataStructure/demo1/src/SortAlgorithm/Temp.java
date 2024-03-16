package SortAlgorithm;

/**
 * @author Lemon
 * @create 2023-04-25-14:18
 */
public class Temp{
    public static void main(String[] args){
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        System.out.println(Solution.isSymmetric(root));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public static boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        if(isSymmetric(root.left)&&isSymmetric(root.right)){
            return true;
        }
        return false;
    }
}