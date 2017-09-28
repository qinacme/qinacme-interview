import java.lang.reflect.Array;
import java.util.Arrays;

public class Prob416 {
    public boolean canPartition(int[] nums) {
        int n=nums.length, sum=0;
        if (n<2){
            return false;
        }
        for (int i: nums){
            sum+=i;
        }
        if (sum%2!=0) return false;
        sum /= 2;
        boolean[][] dp = new boolean[n+1][sum+1];
        for (int i=0;i<n+1;i++){
            Arrays.fill(dp[i],false);
        }
        dp[0][0]=true;
        for (int i=1;i<n+1; i++){
            dp[i][0]=true;
        }
        for (int j=1;j<sum+1;j++){
            dp[0][j]=false;
        }
        for (int i=1;i<n+1; i++){
            for (int j=1;j<sum+1;j++){
                dp[i][j]=dp[i-1][j];
                if (j>=nums[i-1]){
                    dp[i][j]=(dp[i][j]||dp[i-1][j-nums[i-1]]);
                }
            }
        }
        return dp[n][sum];
    }
}
