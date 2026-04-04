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
    int preidx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length-1);
    }
    private int search(int[] inorder, int start, int end, int val){
        for(int i=start; i<=end; i++){
            if(inorder[i] == val){
                return i;
            }
        }
        return -1;  
    }
    private TreeNode helper(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;
        int rootval = preorder[preidx];
        preidx++;
        TreeNode root = new TreeNode(rootval);
        int idx = search(inorder, start, end, rootval);
        root.left = helper(preorder, inorder, start, idx-1);
        root.right = helper(preorder, inorder, idx+1, end);
        return root;
    }
}
