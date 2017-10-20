class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        n = len(digits)
        r = list(digits)
        while n > 0 and r[n-1]==9:
            r[n-1] = 0
            n -= 1
        if n == 0:
            return [1] + r
        r[n-1] = r[n-1] + 1
        return r
