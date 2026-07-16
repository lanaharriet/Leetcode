# Last updated: 7/16/2026, 4:11:19 PM
class Solution(object):
    def sumOfLeftLeaves(self, root):
        def dfs(node, is_left):
            if not node:
                return 0
            if not node.left and not node.right:
                return node.val if is_left else 0
            return dfs(node.left, True) + dfs(node.right, False)
        
        return dfs(root, False)