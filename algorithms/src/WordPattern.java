/**
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/
 */

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static void main(String args[]) {
        System.out.println(wordPattern("aaa", "aa aa aa aa"));
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");

        if(pattern.length() != s.length) return false;

        Map<Character, String> patternDic = new HashMap<>();
        Map<String, Character> wordDic = new HashMap<>();
        for(int i=0; i<pattern.length(); i++) {
            String word = patternDic.get(pattern.charAt(i));

            if(word == null) { //처음 나온 단어인 경우
                patternDic.put(pattern.charAt(i), s[i]);
            } else {
                //패턴에 이미 존재하면 단어가 같아야
                if(!word.equals(s[i])) return false;
            }

            //워드 기준 체크
            if(wordDic.containsKey(s[i])) {
                char patternChar = wordDic.get(s[i]);
                if(patternChar != pattern.charAt(i)) return false;
            }
            wordDic.put(s[i], pattern.charAt(i));
        }
        return true;
    }
}
