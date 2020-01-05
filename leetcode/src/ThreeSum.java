import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> retVal = new HashSet<>();
        Map<Integer, List<Integer>> dic = new HashMap<>();

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
                if(!availableMember(dic, nums[i], nums[j], thirdNum)) continue;

                // sort하는 것보다 직접 순서를 지정하면 50ms정도 빠름
                List<Integer> zeroNums;
                if(thirdNum <= nums[i]) {
                    zeroNums = Arrays.asList(thirdNum, nums[i], nums[j]);
                } else if(thirdNum <= nums[j]) {
                    zeroNums = Arrays.asList(nums[i], thirdNum, nums[j] );
                } else {
                    zeroNums = Arrays.asList(nums[i], nums[j], thirdNum);
                }

                retVal.add(zeroNums);
            }
        }
        return new ArrayList(retVal);
    }

    //if the number used before, the number couldn't be member of sum.
    private boolean availableMember(Map<Integer, List<Integer>> dic, int n1, int n2, int n3) {
        //n1,n2 couldn't duplicated and always exist in dic
        List<Integer> n3List = dic.get(n3);
        if(n3List == null) return false;
        int n3ListSize = n3List.size();
        if(n3ListSize >= 3) return true;

        if(n3 == n1 && n3 != n2) {
            if(n3ListSize >= 2) return true;
        } else if(n3 != n1 && n3 == n2) {
            if(n3ListSize >= 2) return true;
        } else if(n3 != n2 && n3 != n1) return true;

        return false;
    }
}
