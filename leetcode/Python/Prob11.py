class Solution(object):
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if len(height) < 2:
            return 0
        l = 0
        r = len(height) - 1
        area = min(height[l], height[r])*(r-l)
        while l != r:
            if height[l]<height[r]:
                l += 1
            else:
                r -= 1
            area = max(area, min(height[l], height[r])*(r-l))
        return area
