class Solution(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        result = []
        nums = sorted(nums)
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            cur, l, r = nums[i], i+1, len(nums)-1
            while l<r:
                ln, rn, s = nums[l], nums[r], cur+nums[l]+nums[r]
                if s == 0:
                    result.append([cur, ln, rn])
                    while nums[l] == ln and l<r:
                        l+=1
                    while nums[r] == rn and l>r:
                        r-=1
                elif s > 0:
                    r-=1
                else:
                    l+=1
        return result
