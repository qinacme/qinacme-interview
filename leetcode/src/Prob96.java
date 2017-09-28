public class Prob96 {
    public int numTrees(int n) {
        if (n==1)
            return 1;
        int[] nums = new int[n+1];
        nums[0]=nums[1]=1;
        for (int i=2;i<=n;i++){
            nums[i]=0;
            for(int j=1;j<=i;j++){
                nums[i]+=nums[j-1]*nums[i-j];
            }
        }
        return nums[n];
    }
}
