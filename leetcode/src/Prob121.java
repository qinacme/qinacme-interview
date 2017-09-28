public class Prob121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len<2)
            return 0;
        int[] delta = new int[len-1];
        for (int i = 0; i < len - 1; i++) {
            delta[i] = prices[i+1]-prices[i];
        }
        int value = 0;
        int sum = 0;
        for (int i = 0; i < len - 1; i++) {
            sum = sum<0?delta[i]:delta[i]+sum;
            if (sum>value)
                value=sum;
        }
        return value;
    }
}
