#[-2,2,-3,4,-1,2,1,-5,3]
#greedy
def maxSubArray(nums):
    if nums == None or len(nums)==0:
        return 0
    maxSum = nums[0]
    curSum = maxSum
    for i in nums[1:]:
        if curSum<0:
            curSum = i
        else:
            curSum = curSum+i
        maxSum = max(maxSum, curSum)
    return maxSum
#prefix sum
def maxSubArray2(nums):
    if nums == None or len(nums)==0:
        return 0
    maxSum, minSum, curSum = nums[0], nums[0], nums[0]
    for i in nums[1:]:
        curSum += i
        maxSum = max(maxSum, curSum-minSum)
        minSum = min(minSum, curSum)
    return maxSum
if __name__ == '__main__':
    print(maxSubArray([-2,2,-3,4,-1,2,1,-5,3]))
