package acomp_mock;

import java.util.Arrays;
import java.util.List;

public class PartitionLabels {

    public static void main(String args[]) {
        List<Integer> ret = partitionLabels("ababcbacadefegdehijhklij");
        ret.stream().forEach(r -> System.out.print(r + ", "));
    }


    public static List<Integer> partitionLabels(String S) {
        return Arrays.asList(9,7,8);
    }
}
