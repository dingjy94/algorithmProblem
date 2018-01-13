/**
* Given preorder and inorder traversal of a tree, construct the binary tree.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
        return null;
        }
        TreeNode newRoot = new TreeNode(preorder[preStart]);
        
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == newRoot.val) {
                rootIndex = i;
                break;
            }
        }
        newRoot.left = helper(preStart + 1, inStart, rootIndex - 1, preorder, inorder);
        newRoot.right = helper(preStart + rootIndex - inStart + 1, rootIndex + 1, inEnd, preorder, inorder);
        return newRoot;
    }
}
