/**
 * 791. Custom Sort String
 * https://leetcode.com/problems/custom-sort-string/
 */

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

    public static void main(String args[]) {
//        System.out.println(customSortString("cba","abcd"));

        //"hhhhhuucccwaaaaaaaaabbdddddeffffggggiijjjjkkkkllllmmmmnnnoooopppqqqqqqqqqqqrsssttttttttvxxxxxyyzzzzz"
        System.out.println(customSortString("hucw",
        "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"));
//        System.out.println(customSortString("cbafg","abcd"));
    }

    public static String customSortString(String S, String T) {
        //idea
        //T를 한번 읽어서 맵에 넣어둠
        //S를 읽으면서 T맵에서 존재하면 카운트를 하나씩 빼줌, 만약에 카운트가 0이 되었다면 맵에서도 그냥 지워준다.
        //맵을 조회해서 카운트 만큼 문자들을 붙여줌

        StringBuilder retVal = new StringBuilder();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i=0; i<T.length(); i++) {
            tMap.put(T.charAt(i), tMap.getOrDefault(T.charAt(i), 0) + 1);
        }
        //S에는 있는데 T에는 없는 데이터가 존재함
        for(int i=0; i<S.length(); i++) {
            //만약에 T에 존재하면 그때 retVal에 추가해줌
            if(tMap.containsKey(S.charAt(i))) {
                int valCount = tMap.get(S.charAt(i)); //valCount만큼 추가시켜주고, 맵에서 지운다.
                for(int j=0; j<valCount; j++) {
                    retVal.append(S.charAt(i));
                }
                tMap.remove(S.charAt(i));
            }
        }

        for(char c : tMap.keySet()) {
            int valCount = tMap.get(c);
            for(int i=0; i<valCount; i++) {
                retVal.append(c);
            }
        }

        return retVal.toString();
    }
}
