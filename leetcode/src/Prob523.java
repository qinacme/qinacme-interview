public class Prob523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        if (len==0)
            return false;
        if (k==0){
            for (int i=0;i<len-1;i++){
                if (nums[i]==0 && nums[i+1]==0)
                    return true;
            }
            return false;
        }
        if (k<0)
            k = -k;
        int[] presum = new int[len];
        int sum = 0;
        for (int i=0;i<len;i++){
            sum += nums[i];
            if (sum%k==0 && i>0)
                return true;
            presum[i] = sum;
        }
        for (int i=0;i<len;i++){
            for (int j=i+2;j<len;j++){
                if ((presum[j]-presum[i])%k==0)
                    return true;
            }
        }
        return false;
    }
}
