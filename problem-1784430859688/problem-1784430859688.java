// Last updated: 7/19/2026, 8:44:19 AM
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    int count=0;
18    
19    public int countDominantNodes(TreeNode root) {
20        dfs(root);
21        return count;
22        
23    }
24
25    private int dfs(TreeNode node){
26        if(node==null){
27            return Integer.MIN_VALUE;
28        }
29
30        int leftMax=dfs(node.left);
31        int rightMax=dfs(node.right);
32
33        int maxVal=Math.max(node.val,Math.max(leftMax,rightMax));
34
35        if(node.val==maxVal){
36            count++;
37        }
38
39        return maxVal;
40
41    }
42}