/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int leftH = maxHeight(root.left);
        int rightH = maxHeight(root.right);
        int dia = leftH + rightH;
        
        int sub = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(dia, sub);
    }

    public int maxHeight(TreeNode node) {
        if(node == null) return 0;

        return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
    }
}
