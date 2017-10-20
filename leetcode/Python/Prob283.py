class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return
        i, cnt = 0, 0
        while cnt<len(nums):
            if not nums[i]:
                del nums[i]
                nums.append(0)
                cnt+=1
                continue
            cnt+=1
            i+=1
        return
