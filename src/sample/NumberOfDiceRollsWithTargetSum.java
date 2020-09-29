package sample; /**
 * 1155. Number of Dice Rolls With Target Sum
 * https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
 */
//못 품...
//참고 : https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/discuss/355940/C%2B%2B-Coin-Change-2
//유사문제 518. Coin Change 2

import common.Sample;

/**
 * 아래와 같은 점화식인 것 같다는 discuss가 있음 다시 도전 해보기...
 * T(d, t) = 0, if d = 1, t > f;
 * T(d, t) = 0, if d = 1, t <= f
 * T(d, t) = T(d-1, t-i) + ... + T(d-1, t-f), if d > 1 and t - f > 0
 */
@Sample
public class NumberOfDiceRollsWithTargetSum {

    public static void main(String args[]) {
        System.out.println(numRollsToTarget(1, 6, 3));
    }

    public static int numRollsToTarget(int d, int f, int target) {
        return 0;
    }
}
