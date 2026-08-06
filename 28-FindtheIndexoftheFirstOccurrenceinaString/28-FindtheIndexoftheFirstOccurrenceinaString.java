// Last updated: 8/6/2026, 9:15:18 AM
1class Solution {
2    public boolean isBalanced(TreeNode root) {
3        return dfsHeight(root) != -1;
4    }
5
6    private int dfsHeight(TreeNode node) {
7        if (node == null) return 0;
8
9        int leftHeight = dfsHeight(node.left);
10        if (leftHeight == -1) return -1;
11
12        int rightHeight = dfsHeight(node.right);
13        if (rightHeight == -1) return -1;
14
15        if (Math.abs(leftHeight - rightHeight) > 1) {
16            return -1;
17        }
18
19        return 1 + Math.max(leftHeight, rightHeight);
20    }
21}