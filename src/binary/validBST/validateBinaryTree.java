package binary.validBST;
import include.*;
// ===== Solution Code #98=====
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root==null) return true;
        if (!isValidBST(root.left)) return false;
        if (root.val<=pre) return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}

class Solutionpre{
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long minVal, long maxVal){
        if (root==null) return true;
        if (root.val>=maxVal || root.val<=minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }

}

/*
Test case of TreeNode with 10 nodes search binary tree
*/
public class validateBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrToTree(new Integer[] { 5, 1, 8, null, null, 6, 9});
        TreeNode.printPreOrder(root);
        System.out.println(new Solution().isValidBST(root));
        System.out.println(new Solutionpre().isValidBST(root));
    }
}