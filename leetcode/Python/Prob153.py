class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        start, end = 0, len(nums)-1
        while start < end:
            if nums[start] < nums[end]:
                return nums[start]
            mid = (start+end)//2
            if nums[mid] >= nums[start]:
                start = mid+1
            else:
                end = mid
        return nums[start]
