/**
* Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] result = new List[n + 1];
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) return result[0];
        result[0].add(null);
        
        for (int i = 1; i <= n; i++) {
            result[i] = new ArrayList<TreeNode>();
            for (int j = 0; j < i; j++) {
                for (TreeNode left : result[j]) {
                     for (TreeNode right : result[i - j - 1]) {
                         TreeNode tmp = new TreeNode(j + 1);
                         tmp.left = left;
                         tmp.right = changeTree(right, j + 1);
            
                         result[i].add(tmp);
                     }
                }
            }
        }
        return result[n];
    }
    
    private TreeNode changeTree(TreeNode n, int change) {
        if (n == null) return null;
        TreeNode node = new TreeNode(n.val + change);
        node.left = changeTree(n.left, change);
        node.right = changeTree(n.right, change);
        return node;
    }
}
