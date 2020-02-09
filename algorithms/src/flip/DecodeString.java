/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/
 */
package flip;

import common.Flip;

import java.util.Stack;

@Flip
public class DecodeString {
    public static void main(String args[]) {
        System.out.println(decodeString("100[abc]"));
        System.out.println(decodeString("3[a2[c]]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("3[a]2[bc]"));
    }

    /**
     * s = "3[a]2[bc]", return "aaabcbc".
     * s = "3[a2[c]]", return "accaccacc".
     * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
     */
    /**
     * [가 나올때까지 pop해주어야 함
     * pop데이터를 모아둔다.
     * [가 나오면 그 앞에 숫자까지 pop한다.
     * 해당 숫자만큼 반복한 문자열을 push한다.
     */
    public static String decodeString(String s) {

        Stack<String> stack = new Stack();

        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else if(s.charAt(i) == '[') {
                stack.push("[");
            } else if(s.charAt(i) == ']') {
                String local = ""; //[ ] 안에 들어갈 문자열 저장해놓는 용도
                String popdata = stack.pop();

                while(popdata != "[") { //]부터 [사이의 문자를 pop해서 local에 넣는다.
                    local = popdata.concat(local);
                    popdata = stack.pop();
                }
                String countStr = "";
                while(true) {
                    if(stack.isEmpty()) break;
                    String n = stack.peek();
                    if(n!=null) {
                        if(Character.isDigit(n.charAt(0))) countStr = stack.pop().concat(countStr);
                        else break;
                    }
                }

                StringBuilder sb = new StringBuilder();
                for(int j=Integer.valueOf(countStr); j>0; j--) sb.append(local);

                stack.push(sb.toString());
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }

        String retVal = "";
        while(!stack.isEmpty()) {
            retVal = stack.pop().concat(retVal);
        }

        return retVal;
    }
}