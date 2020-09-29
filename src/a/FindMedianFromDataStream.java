package a; /**
 * 295. Find Median from Data Stream
 * https://leetcode.com/problems/find-median-from-data-stream/
 */

import common.A;

import java.util.*;

@A
public class FindMedianFromDataStream {
    public static void main(String args[]) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(6); //6.0
        System.out.println(obj.findMedian());
        obj.addNum(10); //8.0
        System.out.println(obj.findMedian());
        obj.addNum(2); //6.0
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(5);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
        obj.addNum(6);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
        obj.addNum(1);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
        obj.addNum(0);
        System.out.println(obj.findMedian());
    }
}
// https://leetcode.com/problems/find-median-from-data-stream/discuss/343662/JAVA-HEAP-SOLUTION-%2B-2-FOLLOW-UPS
class MedianFinder {
    private Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //큰수가 위, remove 시 작은 수가 빠져나감
    private Queue<Integer> minHeap = new PriorityQueue<>(); //작은수가 위, remove 시 큰 수가 빠져나

    public void addNum(int num) {
        if (maxHeap.size() == minHeap.size()) {
            minHeap.add(num);
            maxHeap.add(minHeap.remove()); //minheap 에서 가장 큰 수를 빼서 maxheap 으로 들어가게 해서 밸런스를 맞춰줌
        } else if (maxHeap.size() > minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.remove()); //maxheap 에서 가장 작은 수를 빼서 minheap 으로 들어가게 해서 밸런스를 맞춤
        } // maxHeap will never be smaller size than minHeap
    }

    public double findMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}

//아래 접근 방법으로는 timeout이 나게 됨...
class MedianFinder2 {
    List<Integer> list;
    public MedianFinder2() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        Collections.sort(list);
    }

    public double findMedian() {
        int length = list.size()-1;
        int medianIndex = length/2;
        if(list.size() == 0) return 0;
        if(list.size() % 2 == 0) //짝수인 경우 length/2, length/2+1 값의 평균이 리턴되어야 함
            return (list.get(medianIndex)+list.get(medianIndex+1)) / (double) 2;

        return list.get(medianIndex);
    }
}
