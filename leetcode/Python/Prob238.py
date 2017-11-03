class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        p = 1
        result = []
        for i in range(n):
            result.append(p)
            p *= nums[i]
        p=1
        for i in range(n-1,-1,-1):
            result[i] *= p
            p *= nums[i]
        return result
