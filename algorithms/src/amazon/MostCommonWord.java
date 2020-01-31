/**
 * 819. Most Common Word
 * https://leetcode.com/problems/most-common-word/
 */
package amazon;

import common.Amazon;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Amazon
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] symbols = new String[]{"!","?","'",",",";",".","  "};
        for(String symbol : symbols) {
            paragraph = paragraph.replace(symbol, " ");
        }

        Map<String, Integer> wordDic = new HashMap<>();
        Set<String> bannedDic = new HashSet<>(); //map보다 더 빠름... 51ms->7ms
        //HashSet이 LinkedHashSet, TreeSet 보다 빠름 (7~15vs19~20vs20~25)
        for(String bannedWord : banned) {
            bannedDic.add(bannedWord);
        }

        String[] words = paragraph.split(" ");
        String retVal = "";
        int max = -1;
        for(String word : words) {
            word = word.toLowerCase();
            if(!bannedDic.contains(word)) {
                int wordDicCount = wordDic.getOrDefault(word, 0) + 1;
                wordDic.put(word, wordDicCount);

                if(max < wordDicCount) {
                    retVal = word;
                    max = wordDicCount;
                }
            }
        }

        return retVal;
    }
}
