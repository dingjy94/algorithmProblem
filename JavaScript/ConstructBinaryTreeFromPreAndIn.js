/**
 * Given preorder and inorder traversal of a tree, construct the binary tree
 */

/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {number[]} preorder
 * @param {number[]} inorder
 * @return {TreeNode}
 */
var buildTree = function(preorder, inorder) {
    return buildTreeHelper(0, 0, inorder.length - 1, preorder, inorder);
};

function buildTreeHelper(index, left, right, preorder, inorder) {
    if (index > preorder.length - 1 || left > right) {
        return null;
    }
    
    const rootVal = preorder[index];
    let root = new TreeNode(rootVal);
    // very useful inbuild array function
    let rootPos = inorder.indexOf(rootVal);

    
    root.left = buildTreeHelper(index + 1, left, rootPos - 1, preorder, inorder);
    root.right = buildTreeHelper(index + 1 + rootPos - left, rootPos + 1, right, preorder, inorder);
    
    return root;
}
