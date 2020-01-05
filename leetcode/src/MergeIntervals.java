import java.util.Arrays;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        if(size==0) return new int[0][0];

        Arrays.sort(intervals, (x, y) -> x[0]-y[0]);

        int[][] merged = new int[size][2];
        merged[0] = intervals[0];

        int pointMerged = 0;
        int pointAppendNode = 1;

        while(true) {
            if(pointAppendNode >= intervals.length) break;

            int startMergedNode = merged[pointMerged][0];
            int endMergedNode = merged[pointMerged][1];

            int startAppendNode = intervals[pointAppendNode][0];
            int endAppendNode = intervals[pointAppendNode][1];

            if(endMergedNode >= startAppendNode) { //merging task target
                merged[pointMerged][0] = startMergedNode;
                merged[pointMerged][1] = Math.max(endMergedNode, endAppendNode);
            } else { //add new node
                pointMerged++;
                merged[pointMerged][0] = startAppendNode;
                merged[pointMerged][1] = endAppendNode;
            }
            pointAppendNode++;

        }
        return Arrays.copyOfRange(merged, 0, pointMerged+1);
    }
}
