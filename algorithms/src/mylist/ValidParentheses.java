/**
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 */
package mylist;

import common.My;

import java.util.Stack;

@My
public class ValidParentheses {
    public static void main(String args[]) {
        System.out.println(isValid("()")); //true
        System.out.println(isValid("()[]{}")); //true
        System.out.println(isValid("(]")); //false
        System.out.println(isValid("([)]")); //false
        System.out.println(isValid("{[]}")); //true
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.add(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if(stack.isEmpty()) return false;
                char pre = stack.pop();
                if(c == ')') {
                    if(pre != '(') return false;
                }
                if(c == '}') {
                    if(pre != '{') return false;
                }
                if(c == ']') {
                    if(pre != '[') return false;
                }
            }
        }
        if(stack.size() > 0) return false;

        return true;
    }
}
