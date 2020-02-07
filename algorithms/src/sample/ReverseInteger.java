package sample;

import common.Sample;

/**
 * 7. Reverse Integer
 * https://leetcode.com/problems/reverse-integer/
 */
@Sample
public class ReverseInteger {

    public static void main(String args[]) {
//        System.out.println(reverse(120));
//        System.out.println(reverse(1534236469));
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) return 0;

        boolean minus = false;
        if(x < 0) {
            minus = true;
            x = x * -1;
        }

        int base = 1;
        for(int i=1; i<String.valueOf(x).length(); i++) {
            base = base * 10;
        }

        int retVal = 0;
        while(base > 0) {
            int mod = x % 10;
            x = x / 10;

            if((retVal/10 + base/10*mod) > (Integer.MAX_VALUE/10))
                return 0;

            retVal = retVal + mod * base;

            base = base / 10;
        }

        return minus == true ? retVal * -1 : retVal;
    }
}
