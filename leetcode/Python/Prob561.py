class Solution(object):
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        r = sorted(nums)
        return sum([r[2*i] for i in range(len(nums)/2)])
