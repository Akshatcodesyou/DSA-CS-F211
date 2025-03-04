package Lab4_Queue;

import java.util.Scanner;

public class Queue {
    private int Size;
    private int front, rear;
    private int[] arr;

    Queue(int Size){
        this.Size = Size;
        arr = new int[Size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(int num){
        if(rear == Size-1){
            System.out.println("Queue full!")
        }
        else{
            if(front == -1){
                front = 0;
            }
            rear++;
            arr[rear] = num;
            System.out.println("Number queued");
        }
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue q1 = new Queue(5);
        q1.enqueue(5);
        q1.enqueue(4);
        q1.enqueue(3);
        q1.enqueue(2);
        scan.close();
    }
}
