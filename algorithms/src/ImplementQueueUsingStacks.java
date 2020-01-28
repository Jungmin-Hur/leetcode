/**
 * 232. Implement Queue using Stacks
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */

import java.util.Stack;

public class ImplementQueueUsingStacks {

    public static void main(String args[]) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty());; // returns false
    }

    private Stack<Integer> stack;
    private Stack<Integer> tempStack;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        //remove 1st item
        int retVal = tempStack.pop();
        while(!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return retVal;
    }

    /** Get the front element. */
    public int peek() {
        while(!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        //find 1st item
        int retVal = tempStack.peek();
        while(!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
        return retVal;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

// more good idea..
// https://leetcode.com/problems/implement-queue-using-stacks/discuss/64206/Short-O(1)-amortized-C%2B%2B-Java-Ruby
// output is real data
//
//class MyQueue {
//
//    Stack<Integer> input = new Stack();
//    Stack<Integer> output = new Stack();
//
//    public void push(int x) {
//        input.push(x);
//    }
//
//    public void pop() {
//        peek();
//        output.pop();
//    }
//
//    public int peek() {
//        if (output.empty())
//            while (!input.empty())
//                output.push(input.pop());
//        return output.peek();
//    }
//
//    public boolean empty() {
//        return input.empty() && output.empty();
//    }
//}