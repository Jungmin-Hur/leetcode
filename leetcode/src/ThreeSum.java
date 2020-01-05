import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> retVal = new HashSet<>();
        Map<Integer, List<Integer>> dic = new HashMap<>();
        // Map<List<Integer>, Integer> checkDup = new HashMap<>();

        int tot = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<tot; i++) {
            List<Integer> index = dic.getOrDefault(nums[i], new ArrayList<>());
            index.add(i);
            dic.put(nums[i], index);
        }

        for(int i=0; i<tot; i++) {
            //if the same value on previous value, it could be skipped!!
            if(i > 0 && nums[i]==nums[i-1]) continue;

            for(int j=i+1; j<tot; j++) {
                if(nums[j]==nums[j-1] && j!=i+1) continue;

                int thirdNum = (nums[i]+nums[j]) * (-1);
                if(!availableMember(dic.get(thirdNum), i, j)) continue;

                // sort하는 것보다 직접 순서를 지정하면 50ms정도 빠름
                // List<Integer> zeroNums = Arrays.asList(nums[i], nums[j], thirdNum);
                // Collections.sort(zeroNums);
                List<Integer> zeroNums;
                if(thirdNum <= nums[i]) {
                    zeroNums = Arrays.asList(thirdNum, nums[i], nums[j]);
                } else if(thirdNum <= nums[j]) {
                    zeroNums = Arrays.asList(nums[i], thirdNum, nums[j] );
                } else {
                    zeroNums = Arrays.asList(nums[i], nums[j], thirdNum);
                }

                // if(checkDup.get(zeroNums) != null) continue;
                retVal.add(zeroNums);
                // checkDup.put(zeroNums, 1);
            }
        }
        return new ArrayList(retVal);
    }

    //if the number used before, the number couldn't be member of sum.
    private boolean availableMember(List<Integer> indexList, int i, int j) {
        if(indexList == null) return false;

        int listSize = indexList.size();
        if(listSize >= 3) return true;
        boolean containsI = indexList.contains(i);
        if(listSize == 2) {
            if(containsI) {
                if(!indexList.contains(j)) return true;
            } else {
                if(indexList.contains(j)) return true;
            }
        }
        if(containsI == false && indexList.contains(j) == false) return true;

        return false;
    }

}
