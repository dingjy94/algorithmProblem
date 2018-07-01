/**
 * Given a non-empty binary search tree and a target value, 
 * find k values in the BST that are closest to the target.
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
     * @param root: the given BST
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        
        traverse(root, inOrder);
        
        int i = 0, n = inOrder.size();
        for(;i < n;i++) {
            if (inOrder.get(i) >= target) {
                break;
            }
        }
        
        if (i == n) {
            return inOrder.subList(n - k, n);
        }
        
        int left = i - 1, right = i;
        for (i = 0; i < k; i++) {
            if (left >= 0 && (right >= n || (target - inOrder.get(left) < (inOrder.get(right) - target)))) {
                result.add(inOrder.get(left--));
            } else {
                result.add(inOrder.get(right++));
            }
        }
        
        return result;
    }
    
    private void traverse(TreeNode root, List<Integer> inOrder) {
        if (root == null) {
            return;
        }
        
        traverse(root.left, inOrder);
        inOrder.add(root.val);
        traverse(root.right, inOrder);
    }
}
