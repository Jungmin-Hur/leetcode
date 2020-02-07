package amock;

public class NumRollsToTarget {

    public static void main(String args[]) {
//        System.out.println(numRollsToTarget(1, 6, 3));
        System.out.println(numRollsToTarget(2, 6, 7));
        System.out.println(numRollsToTarget(2, 5, 10));
    }

    /**
     * 아래와 같은 점화식인 것 같다는 discuss가 있음 다시 도전 해보기...
     * T(d, t) = 0, if d = 1, t > f;
     * T(d, t) = 1 (0이 아니라 1같음..), if d = 1, t <= f
     * T(d, t) = T(d-1, t-i) + ... + T(d-1, t-f), if d > 1 and t - f > 0
     */

    public static int numRollsToTarget(int d, int f, int target) {
        long[][] dp = new long[target+1][d+1];
        for(int i=0; i<target; i++) { //target
            for(int j=0; j<=i && j<=d; j++) { //dice
                if(i==j) {
                    dp[i][j] = 1;
                } else if(j==0) {
                    if(target <= f) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) ;
                }
            }
        }
        return (int) dp[target-1][d-1];
    }

}
