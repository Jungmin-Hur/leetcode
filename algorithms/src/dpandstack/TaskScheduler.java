package dpandstack;

import common.Flip;
import common.FlippedSchoolType;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

@Flip(FlippedSchoolType.DP_STACK)
public class TaskScheduler {

    public static void main(String args[]) {
        System.out.println(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'}, 2)); //8
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 2)); //8
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 0)); //6
        //A를 다시 수행하기 위해 50만큼 기다려야 함
        //A(1), B(2) ... (idle) ... A(52), B(53) ... (idle) ... A(103), B(104)
        System.out.println(leastInterval(new char[]{'A','A','A','B','B','B'}, 50)); //104
    }

    /**
     * Input: tasks = ['A','A','A','B','B','B'], n = 2
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     */
    public static int leastInterval(char[] tasks, int n) {

        //slot은 n만큼 있음
        /**
         * ex. A,A,A,B,B,C 있고 n이 4라면?
         * A B C (idle)
         * A B (idle) (idle)
         * A
         * 해서 총 9가 나옴
         *
         * ex. A,A,A,A,B,B,C,C,D,E,F 있고 n이 4라면?
         * A B C D
         * A B C E
         * A F (idle) (idle)
         * A
         */

//        if(n==0) return tasks.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(char t : tasks) {
            map.put((int)(t-'A'), map.getOrDefault((int)(t-'A'), 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((p1, p2) -> {
            return p2-p1;
        });

        for(Integer i : map.keySet()) {
            pq.offer(map.get(i));
        }

        PriorityQueue<Integer> scheduler = new PriorityQueue<>((s1, s2) -> s1-s2);
        while(!pq.isEmpty()) {
            int taskPoint = pq.poll();

            if(scheduler.size() < (n+1)) { //slot이 총 n개다
                scheduler.offer(taskPoint);
            } else {
                int s = scheduler.poll();
                s = s + taskPoint;
                scheduler.offer(s);
            }
        }

        int maxSchedule = scheduler.poll();
        int sameAsMaxScheduleCount = 1;
        while(!scheduler.isEmpty()) {
            if(scheduler.poll() == maxSchedule) sameAsMaxScheduleCount++;
            else break;
        }
//        System.out.println(maxSchedule + ',' + (n+1) + ',' + sameAsMaxScheduleCount);
        return (maxSchedule -1) * (n+1) + sameAsMaxScheduleCount;
    }
}
