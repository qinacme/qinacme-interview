class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if len(prices) < 2:
            return 0;
        sum([prices[i+1]-price[i] for i in range(len(prices)-1) if prices[i+1]-price[i]>0])
