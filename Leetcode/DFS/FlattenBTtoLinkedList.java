/**
 * Flatten a binary tree to a fake "linked list" in pre-order traversal.
 * Here we use the right pointer in TreeNode as the next pointer in ListNode.
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
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        
        lastNode = root;
        TreeNode curRight = root.right;
        flatten(root.left);
        flatten(curRight);
    }
}
