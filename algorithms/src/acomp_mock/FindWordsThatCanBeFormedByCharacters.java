/**
 * 1160. Find Words That Can Be Formed by Characters
 * https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
 */
package acomp_mock;

import common.Acomp;
import common.MockTest;

import java.util.HashMap;
import java.util.Map;

@Acomp
@MockTest
public class FindWordsThatCanBeFormedByCharacters {

    private static Object Arrays;

    public static void main(String args[]) {
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"}, "atach"));
    }

    //array version (97%)
    public static int countCharacters(String[] words, String chars) {
        int[] dic = new int[26];
        for(int i=0; i<chars.length(); i++) {
            dic[chars.charAt(i)-'a']++;
        }

        int totalLength = 0;
        for(String word : words) {
            boolean find = true;
            int[] temp = new int[26];
            for(int i=0; i<26; i++) temp[i] = dic[i];

            for(int i=0; i<word.length(); i++) {
                temp[word.charAt(i)-'a']--;
                if(temp[word.charAt(i)-'a'] < 0) {
                    find = false;
                    break;
                }
            }
            if(find == true) {
                totalLength += word.length();
            }
        }
        return totalLength;
    }

    //hashmap version (28%)
    public static int countCharacters2(String[] words, String chars) {
        Map<Character, Integer> dic = new HashMap<>();
        for(int i=0; i<chars.length(); i++) {
            dic.put(chars.charAt(i), dic.getOrDefault(chars.charAt(i),0) + 1);
        }

        int totalLength = 0;
        for(String word : words) {
            boolean find = true;
            Map<Character, Integer> temp = new HashMap<>(dic);
            for(int i=0; i<word.length(); i++) {
                temp.put(word.charAt(i), temp.getOrDefault(word.charAt(i), 0) -1);
                if(temp.get(word.charAt(i)) < 0) {
                    find = false;
                    break;
                }
            }
            if(find == true) {
                totalLength += word.length();
            }
        }
        return totalLength;
    }
}
