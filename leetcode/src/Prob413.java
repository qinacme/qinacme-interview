public class Prob413 {
    public int numberOfArithmeticSlices(int[] A) {
        int res=0, cnt=2, n=A.length;
        if (n<2)
            return 0;
        int diff=A[1]-A[0];
        for (int i=1;i<n-1;i++){
            if (A[i+1]-A[i]==diff){
                cnt++;
            }else {
                res+=continuousArithmeticSlices(cnt);
                diff=A[i+1]-A[i];
                cnt=2;
            }
        }
        return res+continuousArithmeticSlices(cnt);
    }
    public int continuousArithmeticSlices(int n){
        if (n<3)
            return 0;
        return 1+(n+2)*(n-3)/2;
    }
}
