package binary.validBST;

import include.TreeNode;
import org.w3c.dom.ls.LSOutput;

/*
    * @Description: 110. Balanced Binary Tree
    * definition: 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */

class Solution110 {
    public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return depth(root)!=-1;

    }

    public int depth(TreeNode root){
        if (root==null) return 0;
        int left = depth(root.left);
        if (left==-1) return -1;
        int right = depth(root.right);
        if (right==-1) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }
}
public class isBalanced {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrToTree(new Integer[] { 5, 1, 8, 3, 3, null, null, null, 3, 3,3 });
        TreeNode.printPreOrder(root);
        System.out.println(new Solution110().isBalanced(root));
    }
}

