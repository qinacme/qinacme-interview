class Solution(object):
    def containsNearbyDuplicate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: bool
        """
        if not nums:
            return False
        pos = {}
        d = k+1
        for i in range(len(nums)):
            n = nums[i]
            if n not in pos:
                pos[n]=i
            else:
                d = i-pos[n]
                if d<=k:
                    return True
                else:
                    pos[n]=i
        return False
