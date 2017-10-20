# from the discussion
class Solution(object):
    def maxProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        r = curmax = curmin = nums[0]
        for num in nums[1:]:
            if num < 0:
                curmax, curmin = curmin, curmax
            curmax=max(num,curmax*num)
            curmin=min(num,curmin*num)
            r = max(r,curmax)
        return r

# First Draft
#############
# class Solution(object):
#     def maxProduct(self, nums):
#         """
#         :type nums: List[int]
#         :rtype: int
#         """
#         if len(nums)==1:
#             return nums[0]
#         zeroIdx = [idx for idx,num in enumerate(nums) if num==0]
#         zeroIdx = [-1] + zeroIdx + [len(nums)+1]
#         result = max(nums)
#         for k in range(len(zeroIdx)-1):
#             sub_nums = nums[zeroIdx[k]+1:zeroIdx[k+1]]
#             if len(sub_nums)==0:
#                 continue
#             if len(sub_nums)==1:
#                 if sub_nums[0]>result:
#                     result = sub_nums[0]
#                 continue
#             accProduct = [1]
#             for idx, num in enumerate(sub_nums):
#                 accProduct.append(accProduct[idx]*num)
#             for i in range(len(sub_nums)):
#                 for j in range(i+1,len(sub_nums)+1):
#                     temp = accProduct[j]/accProduct[i]
#                     if temp > result:
#                         result = temp
#         return result
