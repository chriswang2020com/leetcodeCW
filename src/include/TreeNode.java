package include;
import java.util.*;

/**
 * Definition for a binary tree node.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    /**
     * Generate a binary tree with an array
     * @param arr
     * @return root
     */
    public static TreeNode arrToTree(Integer[] arr) {
        if (arr == null || arr.length == 0) return null;
        return constructTree(arr, 0);
    }

    private static TreeNode constructTree(Integer[] arr, int i) {
        // Base case: if index is out of bounds or the value is null
        if (i >= arr.length || arr[i] == null) return null;

        // Create a new TreeNode
        TreeNode node = new TreeNode(arr[i]);

        // Recursively build the left and right subtrees
        node.left = constructTree(arr, 2*i + 1);
        node.right = constructTree(arr, 2*i + 2);

        return node;
    }
    public static void printPreOrder(TreeNode root) {
        if (root == null) return;

        // Print the current node's value
        System.out.print(root.val + " ");

        // Recursively print the left subtree
        printPreOrder(root.left);

        // Recursively print the right subtree
        printPreOrder(root.right);
    }
    /**
     * Serialize a binary tree to a list
     * @param root
     * @return
     */
    public static List<Integer> treeToList(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<TreeNode>() {{ add(root); }};
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if(node != null) {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            else {
                list.add(null);
            }
        }
        return list;
    }

    /**
     * Get a tree node with specific value in a binary tree
     * @param root
     * @param val
     * @return
     */
    public static TreeNode getTreeNode(TreeNode root, int val) {
        if (root == null)
            return null;
        if (root.val == val)
            return root;
        TreeNode left = getTreeNode(root.left, val);
        TreeNode right = getTreeNode(root.right, val);
        return left != null ? left : right;
    }
}