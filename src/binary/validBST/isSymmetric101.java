package binary.validBST;

import include.TreeNode;

class Solution101{
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        return helpler(root.left,root.right);
    }
    public boolean helpler(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        return q != null && p.val == q.val && helpler(p.left, q.right) && helpler(p.right, q.left);
    }
}
public class isSymmetric101 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrToTree(new Integer[] { 5, 1, 1, 8, 3, 3, 8});
        System.out.println(new Solution101().isSymmetric(root));
    }
}



