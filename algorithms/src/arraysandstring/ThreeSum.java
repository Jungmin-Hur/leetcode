/**
 * 15. 3Sum
 * https://leetcode.com/problems/3sum/
 */
package arraysandstring;

import common.Flip;
import common.FlippedSchoolType;

import java.util.*;

@Flip(value= FlippedSchoolType.ARRAY_STRING)
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> retVal = new HashSet<>();
        Map<Integer, Integer> dic = new HashMap<>();

        int tot = nums.length;

        Arrays.sort(nums);

        for(int num : nums) {
            dic.put(num, dic.getOrDefault(num,0)+1);
        }

        for(int i=0; i<tot; i++) {
            //if the same value on previous value, it could be skipped!!
            if(i > 0 && nums[i]==nums[i-1]) continue;

            for(int j=i+1; j<tot; j++) {
                if(nums[j]==nums[j-1] && j>i+1) continue;

                int n1=nums[i], n2=nums[j];

                int n3 = (n1 + n2) * (-1);
                if(!availableMember(dic, n1, n2, n3)) continue;

                // sort하는 것보다 직접 순서를 지정하면 50ms정도 빠름
                List<Integer> newList;
                if(n3 <= n1) {
                    newList = Arrays.asList(n3, n1, n2);
                } else if(n3 <= n2) {
                    newList = Arrays.asList(n1, n3, n2 );
                } else {
                    newList = Arrays.asList(n1, n2, n3);
                }

                retVal.add(newList);
            }
        }
        return new ArrayList(retVal);
    }

    //if the number used before, the number couldn't be member of sum.
    private boolean availableMember(Map<Integer, Integer> dic, int n1, int n2, int n3) {
        //n1,n2 couldn't duplicated and always exist in dic
        int n3ListSize = dic.getOrDefault(n3, 0);
        if(n3ListSize == 0) return false;
        if(n3ListSize >= 3) return true;

        if(n3 == n1 && n3 != n2) {
            if(n3ListSize >= 2) return true;
        } else if(n3 != n1 && n3 == n2) {
            if(n3ListSize >= 2) return true;
        } else if(n3 != n2 && n3 != n1) return true;

        return false;
    }
}
