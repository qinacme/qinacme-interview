class Solution(object):
    def removeElement(self, nums, val):
        """
        :type nums: List[int]
        :type val: int
        :rtype: int
        """
        cnt = 0
        for i in range(len(nums)):
            if nums[cnt] == val:
                nums.pop(cnt)
                continue
            cnt += 1
        return len(nums)
        
