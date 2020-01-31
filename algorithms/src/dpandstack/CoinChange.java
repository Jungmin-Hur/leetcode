/**
 * 322. Coin Change
 * https://leetcode.com/problems/coin-change/
 */
package dpandstack;

import common.Flip;
import common.FlippedSchoolType;

import java.util.Arrays;


/**
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 */

@Flip(FlippedSchoolType.DP_STACK)
public class CoinChange {
    public static void main(String args[]) {
        System.out.println(coinChange(new int[]{186,419,83,408}, 6249));
//        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
    }

    public static int coinChange(int[] coins, int amount) {
        int[][] dp =  new int[coins.length][coins.length];
        return 0;
    }

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
