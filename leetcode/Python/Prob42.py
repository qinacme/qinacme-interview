class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        stack = []
        r = 0
        for h in height:
            if not stack or stack[0] > h:
                stack.append(h)
                continue
            while stack:
                if len(stack)==1:
                    stack = [h]
                    break
                r += stack[0] - stack.pop()
        while len(stack)>1:
            cur = stack.pop()
            if cur < stack[-1]:
                continue
            while cur >stack[-1]:
                r += cur - stack.pop()
        return r
