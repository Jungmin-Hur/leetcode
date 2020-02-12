package amore;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        //만약 최소값을 추가해야 한다면, 기존 최소값도 stack에 넣어준다.
        if(min >= x) { //min > x인 경우에만 넣으면 안됨. min인 경우 바로 아래꺼를 항상 참조해야 하기 때문에.
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        //최소값이 pop되었다면 기존 최소값을 같이 push해주었기 때문에 다시한번 pop하면서 min값을 업데이트 시켜준다.
        if(stack.pop() == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
