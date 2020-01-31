package mocktest;

import common.MockTest;

@MockTest
public class RepeatedSubstringPattern {
    public static void main(String args[]) {
        System.out.println(repeatedSubstringPattern("babbabbabbabbab"));
        System.out.println(repeatedSubstringPattern("bb"));

        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("ababa"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int length = s.length();

        boolean same = true;
        for(int i=1; i<length; i++) {
            if(s.charAt(0) != s.charAt(i)) same=false;
        }
        if(length > 1 && same == true) return true; //if all data is same, return true;

        int n = length/2; //start number

        for(int i=n; i>1; i--) {
            boolean find = true;
            if(length % i !=0 ) continue; //나누어 떨어지지 않으면 계산 안함
            int jump = length/i;  // 점프할 숫자
            for(int j = 0; j < jump; j++) {
                char ss = s.charAt(j);
                for(int k=j+jump; k < length; k=k+jump) {
                    if(ss != s.charAt(k)) {
                        find = false;
                        break;
                    }
                }

            }
            if(find == true) return true;
        }
        return false;
    }
}
