class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countNode(root.left);
        
        if (leftCount >= k) {
            return kthSmallest(root.left, k);
        } else if (leftCount < k - 1) {
            return kthSmallest(root.right, k - leftCount - 1);
        }
        
        return root.val;
    }
    
    private int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        return 1 + countNode(root.left) + countNode(root.right);
    }
}
