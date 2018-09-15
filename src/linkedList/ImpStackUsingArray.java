package linkedList;

/**
 * Created by vnalubandu on 5/13/18.
 */
public class ImpStackUsingArray {
    public static class Stack<Obj>{

        private Obj[] arr =null;
        private int CAPACITY;
        private int top=-1;
        private int size =0;

        @SuppressWarnings("unchecked")
        public Stack(int capacity){
            this.CAPACITY = capacity;
            this.arr = (Obj[]) new Object[capacity];
        }

        /**
         * Stack POP Operatiom
         * @return
         */
        public Obj pop(){
            // Stack is Last In First Out operation
            // Stack - to remove first element out
            if(this.size==0){
                return null;
            }
            this.size--;
            Obj result = this.arr[top];
            this.arr[top] =null;
            this.top--;
            return result;
        }

        public boolean push(Obj element){
            if(!isFull()){
                return false;
            }

            this.size++;
            this.arr[++top]=element;
            return false;
        }

        public boolean isFull(){
            if(this.size== this.CAPACITY){
                return false;
            }
            return true;
        }

        public String toString(){
            if(!isFull()){
                return null;
            }

            StringBuilder sbr = new StringBuilder();
            for(int i=0;i<size;i++){
                sbr.append(this.arr[i]+", ");
            }
//            sbr.setLength(sbr.length()-1);
//            System.out.println("String length + " + sbr.length());
//            System.out.println("Stack + " + sbr.toString().trim());
            return sbr.toString();
        }


    }

    public static void main(String[] args) {

        Stack<String> stack = new Stack<String>(11);
        stack.push("hello");
        stack.push("world");

        System.out.println(stack);

        stack.pop();
        System.out.println(stack);

        stack.pop();
        System.out.println(stack);
    }
}
