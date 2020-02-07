/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
package dpandstack;

import common.A;
import common.Flip;

@A
@Flip
public class LongestPalindrome {

    public static void main(String args[]) {
        System.out.println(longestPalindrome("bananas")); //""
        System.out.println(longestPalindrome("")); //""
        System.out.println(longestPalindrome("a")); //"a"
        System.out.println(longestPalindrome("aa")); //"aa"
        System.out.println(longestPalindrome("aaa")); //"aaa"
        System.out.println(longestPalindrome("ab")); //
        System.out.println(longestPalindrome("abbb")); //"bbb"
        System.out.println(longestPalindrome("babad")); //"bab"
        System.out.println(longestPalindrome("mbabadkdabad")); //"babadkbabad"
    }

    /**
     * using dp
     * dp (i, j) : si~sj isPalindrome (true, false)
     * dp (i, j) = dp (i+1, j-1) and si == sj
     * kabak => aba가 palindrome이라면,
     * dp (i, i) = true
     * dp (i, i+1) = si == si+1
     *
     */
    public static String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];

        int max = -1;
        String longestPalindromeStr = "";

        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<s.length(); j++) {

                if(i==j) {
                    dp[i][j] = true;
                } else if(j == i + 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
                }

                if(dp[i][j] == true && max < (j - i + 1)) {
                    max = j - i + 1;
                    longestPalindromeStr = s.substring(i, j+1);
                }
            }
        }
        return longestPalindromeStr;
    }

    public static String longestPalindrome1(String s) {
        if(s.isEmpty()) return "";

        int[] length = new int[s.length()];
        char[] word = s.toCharArray();

        /**
         * caadbabdad
         * 1121113571
         */
        int maxLength = 1;
        int maxLengthIndex = 0;
        length[0] = 1;
        for(int i=1; i<s.length(); i++) {
            //이전값하고 같으면 +1
            if(word[i] == word[i-1]) {
                length[i] = length[i-1] + 1;
            } else if((i-1-length[i-1]) >= 0 && word[i] == word[i-1-length[i-1]]) {
                length[i] = length[i-1] + 2;
            } else {
                length[i] = 1;
            }

            if(maxLength <= length[i]) {
                maxLength = length[i];
                maxLengthIndex = i;
            }
        }

        return s.substring(maxLengthIndex-length[maxLengthIndex]+1,maxLengthIndex+1);
    }

    public static String longestPalindrome2(String s) {
        int maxLength = 0;
        String result = "";

        int strLength = s.length();
        int startIndex = 0;

        while(true) {
            if(startIndex >= strLength) break;
            if(maxLength > (strLength-startIndex)) break;

            for(int i=startIndex; i<=strLength; i++) {
                String str = s.substring(startIndex, i);
                if(getPalindromeStr(str) == true) {
                    int length = str.length();
                    if(maxLength <= length) {
                        maxLength = length;
                        result = str;
                    }
                }
            }
            startIndex ++;
        }
        return result;
    }

    public static boolean getPalindromeStr(String str) {
        int strLength = str.length();
        if(strLength == 1) return true;
        if(strLength == 0) return false;

        int lastIndex = strLength-1;

        int n = (strLength/2)+1;
        for(int i=0; i<n; i++) {
            if(str.charAt(i) != str.charAt(lastIndex-i)) {
                return false;
            }
        }
        return true;
    }
}
