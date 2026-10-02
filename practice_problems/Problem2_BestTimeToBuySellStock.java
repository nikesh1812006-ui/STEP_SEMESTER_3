import java.util.Arrays;

/**
 * Problem 2: Best Time to Buy and Sell Stock
 * Scenario: Daily stock price profit maximization
 * 
 * Traverses prices array once, tracking running lowest price seen so far
 * and calculating maximum potential profit.
 */
public class Problem2_BestTimeToBuySellStock {

    /**
     * Calculates the maximum profit achievable from a single buy and sell transaction.
     * 
     * @param prices Array of daily stock prices
     * @return Maximum profit, or 0 if no profit can be made
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int potentialProfit = prices[i] - minPrice;
                if (potentialProfit > maxProfit) {
                    maxProfit = potentialProfit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("=== Best Time to Buy and Sell Stock ===");
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.printf("prices = %s -> Max Profit: %d%n", Arrays.toString(prices1), maxProfit(prices1));

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.printf("prices = %s -> Max Profit: %d%n", Arrays.toString(prices2), maxProfit(prices2));
    }
}
