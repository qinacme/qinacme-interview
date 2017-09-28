public class Prob70 {
    public int climbStairs(int n) {
        if (n<2)
            return 1;
        if (n==2)
            return 2;
        int step = 0;
        int prestep = 2;
        int preprestep = 1;
        for (int i=2; i<n; i++){
            step = prestep + preprestep;
            preprestep = prestep;
            prestep = step;
        }
        return step;
    }
}
