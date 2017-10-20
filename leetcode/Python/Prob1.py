class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        l, r = 0, len(nums)-1
        snums = sorted(nums)
        while snums[l]+snums[r] != target:
            s = snums[l]+snums[r]
            if s < target:
                l += 1
                continue
            r -= 1
        temp = list(nums)
        l = temp.index(snums[l])
        temp[l] = None
        r = temp.index(snums[r])
        return [l,r]
            
