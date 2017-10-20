class Solution(object):
    def countBits(self, num):
        """
        :type num: int
        :rtype: List[int]
        """
        if num == 0:
            return [0]
        if num == 1:
            return [0, 1]
        twoPower, temp = 0, num
        while temp > 0:
            temp //= 2
            twoPower += 1
        result = [0, 1]
        for i in range(twoPower-2):
            result = result + result[2**i:2**(i+1)] + [x+1 for x in result[2**i:2**(i+1)]]
        return result[:num+1]
