package binary.validBST;
import include.TreeNode;
import java.util.List;
import java.util.ArrayList;

class Solution235{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root.val == p.val || root.val == q.val){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }

    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestorBST(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestorBST(root.right, p, q);
        }
        return root;
    }
}
public class lowestCommonAncestor235 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] {6,2,8,0,4,7,9,null,null,3,5};
        TreeNode root = TreeNode.arrToTree(arr);
        TreeNode.printInOrder(root);
        System.out.println("\n");
        Solution235 solution = new Solution235();
        TreeNode result = solution.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println( result.val);
        TreeNode result2 = solution.lowestCommonAncestorBST(root, new TreeNode(2), new TreeNode(4));
        System.out.println(result2.val);
    }
}
