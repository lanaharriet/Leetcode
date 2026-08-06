# Last updated: 8/6/2026, 9:13:48 AM
1class Solution:
2    def isSameTree(self, p, q):
3        # If both nodes are None, they are identical
4        if p is None and q is None:
5            return True
6        # If only one of the nodes is None, they are not identical
7        if p is None or q is None:
8            return False
9        # Check if values are equal and recursively check left and right subtrees
10        if p.val == q.val:
11            return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)
12        # Values are not equal, they are not identical
13        return False