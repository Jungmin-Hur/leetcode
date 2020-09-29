/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/
 */
package flip;

import common.Flip;

import java.util.Arrays;

@Flip
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int intervalsSize = intervals.length;
        if(intervalsSize == 0) return new int[0][0];

        Arrays.sort(intervals, (x, y) -> x[0]-y[0]);

        int[][] merged = new int[intervalsSize][2];
        merged[0] = intervals[0];

        int indexMerged = 0;
        int indexIntervals = 1;

        while(true) {
            if(indexIntervals >= intervalsSize) break;

            int startMergedNode = merged[indexMerged][0];
            int endMergedNode = merged[indexMerged][1];

            int startIntervalsNode = intervals[indexIntervals][0];
            int endIntervalsNode = intervals[indexIntervals][1];

            if(endMergedNode >= startIntervalsNode) { //merging task target
                merged[indexMerged][0] = startMergedNode;
                merged[indexMerged][1] = Math.max(endMergedNode, endIntervalsNode);
            } else { //add new node
                indexMerged++;
                merged[indexMerged][0] = startIntervalsNode;
                merged[indexMerged][1] = endIntervalsNode;
            }
            indexIntervals++;
        }

        return Arrays.copyOfRange(merged, 0, indexMerged+1);
    }
}
