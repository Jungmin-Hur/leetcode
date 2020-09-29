/**
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 */
package flip;

import common.Flip;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Flip
public class WordBreak {
    public static void main(String args[]) {
        System.out.println(wordBreak("leetcode", Arrays.asList("leet", "code")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] d = new boolean[s.length()+1];
        Set<String> set = new HashSet<>(wordDict); //to find wordDict for performance
        d[0] = true;

        /**
         * d[0] = 0
         * d[i] = true, d[j]가 true이고, s.substring(j~i)가 wordDic에 존재하는 경우
         */
        for(int i=1; i <= s.length(); i++) {
            for(int j=0; j< i; j++) {
                if(d[j] == true && set.contains(s.substring(j, i)) == true) {
                    d[i] = true;
                    break;
                }
            }
        }
        return d[s.length()];
    }
}
