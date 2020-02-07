package acomp_mock;

import common.Acomp;
import common.MockTest;

@Acomp
@MockTest
public class LongestPalindrome {
    public static void main(String args[]) {
        System.out.println(longestPalindrome("babd"));
//        System.out.println(longestPalindrome("bab"));
    }

    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int max = Integer.MIN_VALUE;
        String maxString = "";
        for(int i=dp.length-1; i>=0; i--) {
            for(int j=dp.length-1; j>=i; j--) {

                if(i==j) dp[i][j] = true;
                else if(j == i+1) dp[i][j] = (s.charAt(i)==s.charAt(j));
                else {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i)==s.charAt(j));
                }

                if(dp[i][j] == true) {
                    if(max < (j - i - 1)) {
                        max = j - i - 1;
                        maxString = s.substring(i, j + 1);
                    }
                }
            }
        }

//        for(int i=0; i<dp.length; i++) {
//            for (int j = i; j < dp.length; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println("");
//        }
        return maxString;
    }
}
