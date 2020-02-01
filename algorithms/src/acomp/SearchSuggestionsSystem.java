package acomp; /**
 * 1268. Search Suggestions System
 * https://leetcode.com/problems/search-suggestions-system/
 */

import common.Acomp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//need more improvment to trie alogrithm!!!
@Acomp
public class SearchSuggestionsSystem {
    public static void main (String args[]) {
        System.out.println(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> retVal = new ArrayList<>();

        System.out.println("3331111");
        int length = searchWord.length();
        for(int i=1; i<=length; i++) {
            String key = searchWord.substring(0, i);
            System.out.println(key);
            List<String> item = new ArrayList<>();
            for(String product : products) {
                if(product.startsWith(key)) {
                    item.add(product);
                }
                if(item.size()>=3) break;
            }
            retVal.add(item);
        }

        return retVal;
    }
}
