package dpandstack;

import common.Flip;
import common.FlippedSchoolType;

@Flip(FlippedSchoolType.DP_STACK)
public class TaskScheduler {

    public static void main(String args[]) {
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }

    /**
     * Input: tasks = ['A','A','A','B','B','B'], n = 2
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     */
    public static int leastInterval(char[] tasks, int n) {
        return 0;
    }
}
