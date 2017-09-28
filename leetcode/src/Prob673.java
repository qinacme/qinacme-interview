public class Prob673 {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] num = new int[n], len = new int[n];
        for (int i=0; i<n ;i++){
            len[i] = num[i] = 1;
            for (int j=0; j<i; j++){
                if (nums[j]<nums[i]){
                    if (len[j]+1>len[i]){
                        num[i] = num[j];
                        len[i] = len[j] + 1;
                        continue;
                    }
                    if (len[j]+1==len[i]){
                        num[i] += num[j];
                    }
                }
            }
            if (max_len==len[i]) res+= num[i];
            if (max_len<len[i]){
                max_len = len[i];
                res = num[i];
            }
        }
        return res;
    }
}
