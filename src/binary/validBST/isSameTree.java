package binary.validBST;
import include.TreeNode;
import org.w3c.dom.ls.LSOutput;

/*
 * @Description: 100. verify the same tree
 */

class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) return q == null;
        return q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
public class isSameTree {

    public static void main(String[] args) {
        TreeNode p = TreeNode.arrToTree(new Integer[] { 5, 1, 8, 3, 3, null, null, null, 3, 3,3 });
        TreeNode q = TreeNode.arrToTree(new Integer[] { 5, 1, 8, 3, 3, null, null, null, 3, 3,3 });
        System.out.println(new Solution100().isSameTree(p,q));
    }
}
