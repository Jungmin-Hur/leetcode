public class HappyNumber {
    public boolean isHappy(int n) {
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
