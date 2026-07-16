// Last updated: 7/16/2026, 4:11:56 PM
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    private int cnt = 0;
    private int ans = 0;

    public int kthSmallest(TreeNode root, int k) {
        solve(root, k);
        return ans;
    }

    private void solve(TreeNode root, int k) {
        if (root == null) return;
        solve(root.left, k);
        cnt++;
        if (cnt == k) {
            ans = root.val;
            return; 
        }

        solve(root.right, k);
    }
}