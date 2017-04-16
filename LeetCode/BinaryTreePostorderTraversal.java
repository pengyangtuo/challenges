import java.util.*;

class BinaryTreePostorderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void postOrderTraversalHelper(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        postOrderTraversalHelper(root.left, list);
        postOrderTraversalHelper(root.right, list);

        list.add(root.val);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postOrderTraversalHelper(root, res);
        return res;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal sol = new BinaryTreePostorderTraversal();

        TreeNode root = sol.new TreeNode(1);
        root.right = sol.new TreeNode(2);
        root.right.left = sol.new TreeNode(3);

        System.out.println(sol.postorderTraversal(root));
    }
}