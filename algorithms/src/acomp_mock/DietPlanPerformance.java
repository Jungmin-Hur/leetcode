/**
 * 1176. Diet Plan Performance
 * https://leetcode.com/problems/diet-plan-performance/
 */
package acomp_mock;

import common.Acomp;
import common.MockTest;

import java.util.LinkedList;
import java.util.Queue;

@Acomp
@MockTest
public class DietPlanPerformance {

    public static void main(String args[]) {
        System.out.println(dietPlanPerformance(new int[]{1,2,3,4,5}, 1, 3, 3));
        System.out.println(dietPlanPerformance(new int[]{3,2}, 1, 0, 2));
        System.out.println(dietPlanPerformance(new int[]{6,5,0,0}, 2, 1, 5));
    }

    /**
     * A sliding-window is common idea and I also implemented queue version experimentally.
     * A sliding-window version was 1ms, but a queue version was 8ms.
     * Queue version was so slow~!!
     */
    /**
     * #1 using a sliding-window
     */
    public static int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int ans = 0, caloriesSum = 0; //sum of calories

        for(int i=0; i<k; i++) caloriesSum += calories[i];

        int index = k;
        while(true) {
            if(caloriesSum < lower) ans--;
            else if(caloriesSum > upper) ans++;

            if(index >= calories.length) break;
            caloriesSum -= calories[index-k]; //move start point
            caloriesSum += calories[index++]; //add next index of calories
        }

        return ans;
    }

    /**
     * using a queue
     */
    public static int dietPlanPerformanceWithQueue(int[] calories, int k, int lower, int upper) {
        int totPoint = 0;

        Queue<Integer> queue = new LinkedList<>();
        int calSum = 0;

        for(int calory : calories) {
            queue.offer(calory);
            calSum += calory;

            if(queue.size() == k) {
                totPoint += getPoint(calSum, lower, upper);
            } else if(queue.size() > k) {
                int n = queue.poll();
                calSum -= n;
                totPoint += getPoint(calSum, lower, upper);
            }
        }

        return totPoint;
    }

    public static int getPoint(int val, int lower, int upper) {
        if(val < lower) return -1;
        if(val > upper) return 1;
        return 0;
    }
}
