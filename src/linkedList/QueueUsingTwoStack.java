package linkedList;

import java.util.Stack;

/**
 * Created by vnalubandu on 6/30/18.
 */
public class QueueUsingTwoStack {

    Stack<Integer> temp = new Stack<>();
    Stack<Integer> queue = new Stack<>();

    public void pushQueue(int element){
        if(queue.isEmpty()){
            queue.push(element);
        }else{
            while (!queue.isEmpty()){
                temp.push(queue.pop());
            }

            queue.push(element);

            while (!temp.isEmpty()){
                queue.push(temp.pop());
            }
        }
    }

    public void popQueue(){
        queue.pop();
    }

    public int top(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }


    public static void main(String[] args){
        QueueUsingTwoStack queue = new QueueUsingTwoStack();
        queue.pushQueue(1);
        queue.pushQueue(2);
        queue.pushQueue(3);
        System.out.println("Top Element in queue" + queue.top());
        queue.popQueue();
        System.out.println("Top Element in queue" + queue.top());
        queue.pushQueue(4);
        queue.pushQueue(5);
        queue.popQueue();
        queue.popQueue();
        queue.popQueue();
        System.out.println("Top Element in queue" + queue.top());
    }
}
