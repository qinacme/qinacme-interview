# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def dsfHeight(self, root):
        if root==None:
            return 0
        lh, rh = self.dsfHeight(root.left), self.dsfHeight(root.right)
        if lh == -1 or rh == -1 or abs(lh-rh)>1:
            return -1
        return 1 + max(lh, rh)
    def isBalanced(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        return not self.dsfHeight(root) == -1
