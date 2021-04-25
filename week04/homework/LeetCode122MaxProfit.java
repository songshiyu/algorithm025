/**
 * @author songshiyu 买卖股票的最佳时机 II
 * @create: 2021/4/25 08:10:22
 **/
public class LeetCode122MaxProfit {

    public int maxProfit(int[] prices) {
        int sum = 0;
        //主要就是考虑卖出时收益为正即可
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                sum += (prices[i] - prices[i - 1]);
            }
        }
        return sum;
    }
}
