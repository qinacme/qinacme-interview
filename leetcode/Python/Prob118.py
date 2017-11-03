class Solution(object):
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        if numRows == 0:
            return []
        if numRows == 1:
            return [[1]]
        if numRows == 2:
            return [[1],[1,1]]
        r = [[1],[1,1]]
        for i in range(2, numRows):
            r.append([1]+[r[i-1][j]+r[i-1][j+1] 
            for j in range(len(r[i-1])-1)]+[1])
        return r
