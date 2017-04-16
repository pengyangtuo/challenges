import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class FindLargestValueInEachTreeRow {

    public void stringQ(LinkedList<TreeNode> input){
        for(int i=0; i<input.size(); i++){
            System.out.print(input.get(i).val+" ");
        }
        System.out.println();
    }

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curLayerSize = 1;
        int nextLayerSize = 0;
        int layerMax = root.val;
        while(queue.size() != 0){
            TreeNode t = queue.removeFirst();

            if(t.val > layerMax){
                layerMax = t.val;
            }

            curLayerSize--;
            if(t.left != null){
                queue.addLast(t.left);
                nextLayerSize++;
            }

            if(t.right != null){
                queue.addLast(t.right);
                nextLayerSize++;
            }

            if(curLayerSize == 0){
                res.add(layerMax);
                curLayerSize = nextLayerSize;
                nextLayerSize = 0;
                layerMax = Integer.MIN_VALUE;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindLargestValueInEachTreeRow sol = new FindLargestValueInEachTreeRow();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(sol.largestValues(root));
    }
}