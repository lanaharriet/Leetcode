// Last updated: 8/6/2026, 9:14:45 AM
1class Solution {
2    public TreeNode sortedArrayToBST(int[] nums) {
3        return convert(nums, 0, nums.length - 1);        
4    }
5
6    private TreeNode convert(int[] nums, int left, int right) {
7        if (left > right) {
8            return null;
9        }
10        
11        int mid = left + (right - left) / 2;
12        
13        TreeNode node = new TreeNode(nums[mid]);
14        
15        node.left = convert(nums, left, mid - 1);
16        node.right = convert(nums, mid + 1, right);
17        
18        return node;
19    }    
20}