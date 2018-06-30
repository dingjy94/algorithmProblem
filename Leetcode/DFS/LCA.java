/**
 * Given the root and two nodes in a Binary Tree. 
 * Find the lowest common ancestor(LCA) of the two nodes.
 * The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
 * Return null if LCA does not exist.
 */

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    private TreeNode result;
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        helper(root, A, B);
        return result;
    }
    
    private boolean helper(TreeNode root, TreeNode A, TreeNode B) {
        if (result != null) {
            return false;
        }
        
        if (root == null) {
            return false;
        }
        
        boolean left = helper(root.left, A, B);
        boolean right = helper(root.right, A, B);
        
        if (left && right) {
            result = root;
            return false;
        }
        if (left || right) {
            if (root == A || root == B) {
                result = root;
                return false;
            }
            return true;
        }
        
        if (root == A && root == B) {
            result = root;
            return false;
        }
        
        if (root == A || root == B) {
            return true;
        }
        
        return false;
    }
}
