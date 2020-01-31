/**
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
package dpandstack;

import common.Amazon;
import common.Flip;
import common.FlippedSchoolType;

@Amazon
@Flip(FlippedSchoolType.DP_STACK)
public class LongestPalindrome {
    public String longestPalindrome(String s) {
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

    public boolean getPalindromeStr(String str) {
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
