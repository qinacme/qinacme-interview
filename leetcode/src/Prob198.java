public class Prob198 {
    public int rob(int[] nums){
        int len = nums.length;
        if (len == 0)
            return 0;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);
        int[] value = new int[len];
        value[0] = nums[0];
        value[1] = Math.max(nums[0], nums[1]);
        for (int i=2; i<len; i++){
            if (value[i-1] == value[i-2])
                value[i] = value[i-1] + nums[i];
            else
                value[i] = Math.max(value[i-2]+nums[i], value[i-1]);
        }
        return value[len-1];
    }
}