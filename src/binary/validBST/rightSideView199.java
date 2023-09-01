package binary.validBST;
import include.TreeNode;
import java.util.List;
import java.util.ArrayList;

class Solution199 {
    List<Integer> ans = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        helper(root, 0);
        return ans;
    }
    // 先序遍历的思路
    public void helper(TreeNode node, int depth) {
        if (node == null) return;

        if (depth == ans.size()) {
            ans.add(node.val);
        }
        helper(node.right, depth + 1);
        helper(node.left,  depth + 1);
    }
}

public class rightSideView199 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrToTree(new Integer[] { 5, 1, 8, 3, 3, null, null, null, 3, 3, 3 });
        Solution199 solution = new Solution199();
        List<Integer> result = solution.rightSideView(root);
        System.out.println(result);  // Expected output: [5, 8, 3, 3]
    }
}