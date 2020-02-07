/**
 * 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 */
package amock;

import common.A;
import common.Sample;

@A
@Sample
public class ReverseStringII {
    public static void main(String args[]) {
        //every 2k, start~start+k characters reverse!!
        System.out.println(reverseStr("abcdefg", 8)); //gfedcba
        System.out.println(reverseStr("a", 2)); //a
        System.out.println(reverseStr("abcdefg", 2)); //bacdfeg
        System.out.println(reverseStr("abcd", 2)); //bacd
        System.out.println(reverseStr("abcdefabcd", 3)); //cbadef
    }

    //if only using a 1 array, it will be more faster...
    //char[] version is faster than reverseStrWithCharArray()
    public static String reverseStr(String s, int k) {
        char[] origin = s.toCharArray();
        char[] ret = new char[s.length()];

        int start = 0;
        int retIndex = 0;
        while(start < s.length()) {
            for(int i=start + (k-1); i >= start; i--) {
                if(i > s.length()-1) break;
                ret[retIndex++] = origin[i];
            }
            for(int i=start + k; i < start+2*k; i++) {
                if(i > s.length()-1) break;
                ret[retIndex++] = origin[i];
            }

            start = start + 2 * k;
        }
        if(retIndex < s.length()) {
            int last = retIndex;
            for(int i = s.length()-1; i >= last; i--) {
                ret[retIndex++] = origin[i];
            }
        }
        return new String(ret);
    }

    //char[] version is faster than stingbuild version
    public static String reverseStrWithCharArray(String s, int k) {
        char[] ret = s.toCharArray();

        int start = 0;
        int retIndex = 0;
        while(start < s.length()) {
            for(int i=start + (k-1); i >= start; i--) {
                if(i > s.length()-1) break;
                ret[retIndex++] = s.charAt(i);
            }
            for(int i=start + k; i < start+2*k; i++) {
                if(i > s.length()-1) break;
                ret[retIndex++] = s.charAt(i);
            }

            start = start + 2 * k;
        }
        if(retIndex < s.length()) {
            int last = retIndex;
            for(int i = s.length()-1; i >= last; i--) {
                ret[retIndex++] = s.charAt(i);
            }
        }
        return new String(ret);
    }


    //StringBuilder version
    public static String reverseStrWithStringBuilder(String s, int k) {
        int start = 0;
        StringBuilder ans = new StringBuilder();
        while(start < s.length()) {
            for(int i=start + (k-1); i >= start; i--) {
                if(i > s.length()-1) break;
                ans.append(s.charAt(i));
            }
            for(int i=start + k; i < start+2*k; i++) {
                if(i > s.length()-1) break;
                ans.append(s.charAt(i));
            }

            start = start + 2 * k;
        }
        if(ans.length() < s.length()) {
            int last = ans.length();
            for(int i = s.length()-1; i >= last; i--) {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
