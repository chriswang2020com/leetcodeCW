package binary.validBST;
import com.sun.source.tree.Tree;
import include.TreeNode;
import java.util.List;
import java.util.ArrayList;
class Solution99 {
    public void recoverTree(TreeNode root){
        List<TreeNode> list = new ArrayList<TreeNode>();
        dfs(root,list);
        TreeNode x = null, y = null;
        // find x, y wrong node
        for (int i = 0 ; i < list.size()-1; ++i){
            if (list.get(i).val > list.get(i+1).val){
                y = list.get(i+1);
                if (x == null){
                    x = list.get(i);
                }
            }
        }
        // switch the nodes
        if (x!=null && y!=null){
            int tmp = x.val;
            x.val = y.val;
            y.val = tmp;
        }

    }

    private void dfs (TreeNode node, List<TreeNode> list){
        if (node == null) return;
        dfs(node.left, list);
        list.add(node);
        dfs(node.right, list);
    }

}
public class recoverTree99 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.arrToTree(new Integer[] {3,1,4,null,null,2, null});
        TreeNode.printInOrder(root);
        System.out.println("\n");
        Solution99 solution = new Solution99();
        solution.recoverTree(root);
        TreeNode.printInOrder(root);
    }
}
