import java.util.*;
public class Queue {
    int size = 5;
    int numbers[] = new int[size];
    int front;
    int end ;

    Queue() {
        front = -1;
        end = -1;
    }

    boolean isFull() {
        if (front == 0 && end == size - 1) {
            return true;
        }
        return false;
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enQueue(int num) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            end++;
            numbers[end] = num;
            System.out.println("Insert " + num);
        }
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            int element = numbers[front];
            if (front >= end) {
                front = -1;
                end = -1;
            } else {
                front++;
            }
            return element;
        }
    }

    public static void main(String[] args) {

        Queue q = new Queue();
        int i=0;
        while(i<5){
            q.enQueue(i);
            i++;
        }
        q.deQueue();
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);

        System.out.println("Peek: " + cq.peek());
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Peek after dequeue: " + cq.peek());
        LinearQueue queue = new LinearQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued : " + queue.dequeue());

    }
}
class CircularQueue {
    int maxSize;
    int[] Cnumbers;
    int front;
    int end;

    public CircularQueue(int size) {
        maxSize = size;
        Cnumbers = new int[maxSize];
        front = -1;
        end = -1;
    }
    public boolean isEmpty() {
        return front == -1 && end == -1;
    }


    public void enqueue(int item) {
        if (isEmpty()) {
            front = 0;
            end  = 0;
            Cnumbers[end] = item;
        }
        else {
            end = (end + 1) % maxSize;
            if (end == front) {
                System.out.println("Queue is full. Cannot enqueue.");
                end = (end - 1 + maxSize) % maxSize;
            } else {
                Cnumbers[end] = item;
            }
        }
    }

    public int dequeue() {
        int item = -1;
        if (!isEmpty()) {
            item = Cnumbers[front];
            if (front == end) {
                front = -1;
                end = -1;
            } else {
                front = (front + 1) % maxSize;
            }
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
        }
        return item;
    }

    public int peek() {
        if (!isEmpty()) {
            return Cnumbers[front];
        }
        else {
            System.out.println("Queue is empty.");
            return -1;
        }
    }


    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);

        System.out.println("Peek: " + cq.peek());
        System.out.println("Dequeue: " + cq.dequeue());
        System.out.println("Peek after dequeue: " + cq.peek());
    }
}


class LinearQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public LinearQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        LinearQueue queue = new LinearQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued : " + queue.dequeue());

    }
}



