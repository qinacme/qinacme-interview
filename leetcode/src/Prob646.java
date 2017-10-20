import java.util.Arrays;

public class Prob646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) {
            return 0;
        }
        int len = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[len];
        dp[0]=1;
        for (int i=0; i<len; i++){
            int pathLen = 1;
            for (int j=0; j<i;j++)
                if (pairs[j][1]<pairs[i][0] && dp[j]+1>pathLen)
                    pathLen = dp[j]+1;
            dp[i] = pathLen;
        }
        int res = 0;
        for (int i :dp){
            if (res<i)
                res = i;
        }
        return res;
    }
}
