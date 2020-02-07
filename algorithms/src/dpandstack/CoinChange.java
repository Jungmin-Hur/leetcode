/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 */
package dpandstack;

import common.Flip;

import java.util.Arrays;


/**
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 */

@Flip
public class CoinChange {
    public static void main(String args[]) {
        System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    //using dp
    public static int coinChange(int[] coins, int amount) {
        int[] dp =  new int[amount+1]; //coins으로 만들수 있는 데이터를 구함...

        for(int coin : coins) {
            if(amount >= coin) {
                dp[coin] = 1;
            }
        }

        for(int i=1; i <= amount; i++) {
            if(dp[i] == 1) continue;
            for(int j = 0; j < coins.length; j++) {
                int localMin = Integer.MAX_VALUE;
                for(int k=0; k<coins.length; k++) {
                    if(i-coins[k] >= 0 && dp[i-coins[k]] > 0) { //값이 존재하는 경우
                        localMin = Math.min(localMin, dp[i-coins[k]] + 1);
                    }
                }
                if(localMin < Integer.MAX_VALUE) {
                    dp[i] = localMin;
                } else {
                    dp[i] = -1;
                }
            }
        }

        return dp[amount];
    }

    //below code is not working properly
    //아래 케이스는 순차적으로 데이터가 들어있는 것이 보장되어야만 처리가 가능함
    //new int[]{186,419,83,408}, 6249) 인 경우는 -1이 되어 데이터를 찾지 못함
    public static int coinChange2(int[] coins, int amount) {
        int coinCount = 0;

        Arrays.sort(coins);
        int i = coins.length-1;
        while(amount > 0) {
            if(amount >= coins[i]) {
                amount = amount - coins[i];
                coinCount ++;
                System.out.println(coins[i] + "," + coinCount + "," + amount);
            } else {
                i--;
            }

            if(amount != 0 && i < 0) return -1;
        }

        return amount == 0 ? coinCount : -1;
    }
}
