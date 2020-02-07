/**
 * 121. Best Time to Buy and Sell Stock
 */
package amore;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1,4}));
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,5,4,3,2}));
    }

    //one pass approach (1ms)
    //left -> right하면서 ...
    //최소값을 세팅해주는데, 만약에 최소값이 갱신된다면, 갱신된 최소값을 기준으로 최대값을 구한다.
    public static int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for(int price : prices) {
            if(price < minprice) {
                minprice = price;
            }
            else {
                if(maxprofit < price - minprice)
                maxprofit = price - minprice;
            }
        }
        return maxprofit;
    }

    //264ms
    public static int maxProfit1(int[] prices) {
        int max = 0;
        for(int i=0; i<prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                if(prices[j] > prices[i]) {
                    max = Math.max(prices[j]-prices[i], max);
                }
            }
        }
        return max;
    }

    //brute force (2275ms)
    public static int maxProfit2(int[] prices) {

        int max = 0;
        for(int i=0 ;i<prices.length; i++) {
            int min = prices[i];
            prices[i] = -1;

            int[] temp = new int[prices.length];
            for(int j=0; j<prices.length; j++) {
                temp[j] = prices[j];
            }

            Arrays.sort(temp);
            int localmax = temp[temp.length-1];
            if(localmax - min > 0) {
                max = Math.max(localmax - min, max);
            }
        }
        return max;
    }

}
