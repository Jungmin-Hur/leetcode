/**
 * 22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 */
// refer to solutions...

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    /**
     * For example, given n = 3, a solution set is:
     * [
     *   "((()))",
     *   "(()())",
     *   "(())()",
     *   "()(())",
     *   "()()()"
     * ]
     * @param args
     */
    public static void main(String args[]) {

        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        return BACKTRACKING_generateParenthesis(n);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //bruteforce version
    public static List<String> BRUTE_FORCE_generateParenthesis(int n) {
        List<String> combinations = new ArrayList();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    public static boolean valid(char[] current) {
        int balance = 0;
        for (char c: current) {
            if (c == '(') balance++;
            else balance--;
            if (balance < 0) return false;
        }
        return (balance == 0);
    }


    ////////////////////////////////////////////////////////////////////////////////////
    //backtracking version
    public static List<String> BACKTRACKING_generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //Closure Number version
    public static List<String> CLOSURE_NUMBER_generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: CLOSURE_NUMBER_generateParenthesis(c))
                    for (String right: CLOSURE_NUMBER_generateParenthesis(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }
}
