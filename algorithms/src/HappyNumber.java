import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String args[]) {
        System.out.println(isHappy(1));
    }

    public static boolean isHappy(int n) {
        Set<Integer> map = new HashSet<>();

        int total = 1;
        while(total > 0) {
            total = 0;
            int mod=0;
            while(n > 0) {
                mod = n%10;
                n = n /10;
                total += (mod*mod);
            }
            if(total == 1) break;

            if(map.contains(total)) return false;
            map.add(total);
            n = total;
        }
        return true;
    }
    public boolean isHappy2(int n) {
        String str = String.valueOf(n);
        int[] squared = new int[10];
        for(int i=0; i<10; i++) {
            squared[i] = i*i;
        }

        int total = 0;
        int count = 0;
        while(true) {
            System.out.println(str);
            if(total == 1) return true;
            int strLength = str.length();
            if(count++ >= 6) return false;//int size : -2147483648 ~ 2147483647

            int[] strNum = new int[10];
            for(int i=0; i<strLength; i++) {
                strNum[i] = str.charAt(i) - '0';
            }
            total = 0;
            for(int i=0; i<strLength; i++) {
                total += squared[strNum[i]];
            }
            str = String.valueOf(total);
        }
    }
}
