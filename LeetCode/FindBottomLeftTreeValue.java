class FindBottomLeftTreeValue {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Res {
        TreeNode res;
        int depth;
        Res(TreeNode r, int d){
            res = r;
            depth = d;
        }
    }

    public Res findBottomLeftValue(TreeNode root, int depth) {

        if(root.left == null && root.right == null){
            return new Res(root, depth);
        }else if(root.left == null){
            return findBottomLeftValue(root.right, depth+1);
        }else if(root.right == null){
            return findBottomLeftValue(root.left, depth+1);
        }else{
            Res left = findBottomLeftValue(root.left, depth+1);
            Res right = findBottomLeftValue(root.right, depth+1);
            if(right.depth > left.depth){
                return right;
            }else{
                return left;
            }
        }
    }

    public int findBottomLeftValue(TreeNode root) {

        return findBottomLeftValue(root, 1).res.val;
    }

    public static void main(String[] args) {
        FindBottomLeftTreeValue sol = new FindBottomLeftTreeValue();

        TreeNode root = sol.new TreeNode(1);
        root.left = sol.new TreeNode(2);
        root.right = sol.new TreeNode(3);
        root.left.left = sol.new TreeNode(4);
        root.right.left = sol.new TreeNode(5);
        root.right.left.left = sol.new TreeNode(7);
        root.right.right = sol.new TreeNode(6);

        System.out.println(sol.findBottomLeftValue(root));
    }
}