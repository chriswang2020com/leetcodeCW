package binary.validBST;
import include.*;
// ===== Solution Code =====
class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 访问左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 访问当前节点：如果当前节点小于等于中序遍历的前一个节点，说明不满足BST，返回 false；否则继续遍历。
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 访问右子树
        return isValidBST(root.right);
    }
}

/*
Test case of TreeNode with 10 nodes search binary tree
*/
public class validateBinaryTree {
    public static void main(String[] args) {
        Integer[] arr = {5,1,4,null,null,3,6};
        TreeNode root = TreeNode.arrToTree(arr);
        System.out.println(new Solution().isValidBST(root));
    }
}