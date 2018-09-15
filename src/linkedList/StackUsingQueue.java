package linkedList;

import java.util.LinkedList;

/**
 * Created by vnalubandu on 6/30/18.
 */
public class StackUsingQueue {

    LinkedList<Integer> queue1 = new LinkedList<>();
    LinkedList<Integer> queue2 = new LinkedList<>();

    /*
        Queue works as First In First Out
        Stack works as Last In First Out
        push 2
        push 3

     */

    public void pushStack(int element){
        if(queue1.isEmpty()){
            queue2.offer(element);
        }else {
            if(queue1.size()>0){
                queue2.offer(element);
                int size = queue1.size();
                while (size>0){
                    queue2.offer(queue1.poll());
                    size--;
                }
            } else if(queue2.size()>0){
                queue1.offer(element);
                int size = queue2.size();
                while (size>0){
                    queue1.offer(queue2.poll());
                    size--;
                }
            }
        }
    }

    public void popStack(){
        if(queue1.size()>0){
            queue1.poll();
        }else if(queue2.size()>0){
            queue2.poll();
        }
    }

    public int topStack(){
        if(queue1.size()>0){
            queue1.peek();
        }else if(queue2.size()>0){
            queue2.peek();
        }
        return 0;
    }

    public boolean empty() {
        return queue1.isEmpty() & queue2.isEmpty();
    }

    public static void main(String[] args){

    }

}
