/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 */
public class RemoveKDigits {

    public static void main(String args[]) {
        System.out.println(removeKdigits("1107", 1));
        System.out.println(removeKdigits("0", 0));
        System.out.println(removeKdigits("1432219", 3));
        System.out.println(removeKdigits("10200", 1));
        System.out.println(removeKdigits("10", 2));
    }

    public static String removeKdigits(String num, int k) {
        //지울 것이 K개면..
        //num에서 첫번째 수를 지운다고 가정... 0~n-k 수중 가장 작은 것을 선택함
        //num에서 두번째 수를 지운다고 가정, 1번에서 찾은 숫자 다음부터... ~n-(k-1) 중 가장 작은 것을 선택함

        if(k==0) return num;

        StringBuffer sb = new StringBuffer();
        int countForFind = num.length() - k;
        int start = 0;
        int end = num.length() - countForFind;
        while(true) {
            if(countForFind == 0) break; //더 이상 찾을 것이 없으면...
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for(int i=start; i<=end; i++) {
                if(min > (num.charAt(i) - '0')) {
                    min = num.charAt(i) - '0';
                    minIndex = i;
                }
            }
            System.out.println(start+ "," + end + "," + countForFind + ",min:"+min + "," + minIndex + "," + sb.toString());
            if(sb.length() == 0 && num.charAt(minIndex) == '0') { // 제일 첫자리는 0이 될 수 없음
            } else {
                sb.append(num.charAt(minIndex));
            }

            countForFind--; //하나 찾았음..
            start = minIndex + 1;
            end = num.length() - countForFind;
        }

        return sb.length()==0 ? "0" : sb.toString();
    }
}
