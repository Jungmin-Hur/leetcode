package hashtable;

import common.Flip;
import common.FlippedSchoolType;

import java.util.HashMap;
import java.util.Map;

@Flip(value= FlippedSchoolType.HASH_TABLE)
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int max_count = 0,local_count = 0,start_index = 0;
        int n=s.length();

        for(int i=0;i<n;i++) {
            char cur = s.charAt(i);
            local_count ++;
            int duplicatedIndex = dic.getOrDefault(cur, -1);
            if(duplicatedIndex > -1) {
                if(start_index <= duplicatedIndex) {
                    local_count = i - duplicatedIndex;
                    start_index = duplicatedIndex+1; //update start_index
                }
            }
            dic.put(cur, i);
            max_count = Math.max(max_count, local_count);
        }
        return max_count;
    }
}
