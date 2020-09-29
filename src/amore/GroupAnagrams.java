/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/
 */
package amore;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for(String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> list = anagrams.getOrDefault(sortedStr, new ArrayList<String>());
            list.add(str);
            anagrams.put(sortedStr, list);
        }
        List<List<String>> res = new ArrayList<>();
        for(String key : anagrams.keySet()) {
            res.add(anagrams.get(key));
        }
        return res;
    }
}
