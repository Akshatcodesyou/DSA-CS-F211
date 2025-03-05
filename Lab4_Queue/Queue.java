package Lab4_Queue;

import java.io.*;
import java.util.*;

class Studentinfo {
    String IDNO, NAME, DOB;
    double CGPA;

    public Studentinfo(String IDNO, String NAME, String DOB, double CGPA) {
        this.IDNO = IDNO;
        this.NAME = NAME;
        this.DOB = DOB;
        this.CGPA = CGPA;
    }

    @Override
    public String toString() {
        return IDNO + ", " + NAME + ", " + DOB + ", " + CGPA;
    }
}

public class Queue {
    private int Size;
    private int front, rear;
    private Studentinfo[] arr;

    Queue(int Size) {
        this.Size = Size;
        arr = new Studentinfo[Size];
        this.front = -1;
        this.rear = -1;
    }

    public void enqueue(Studentinfo record) {
        if ((rear + 1) % Size == front) {
            System.out.println("Queue is full! Cannot enqueue.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % Size;
            arr[rear] = record;
            System.out.println("Record queued: " + record);
        }
    }

    public Studentinfo dequeue() {
        if (front == -1) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return null;
        } else {
            Studentinfo dequeuedRecord = arr[front];
            System.out.println("Dequeuing: " + dequeuedRecord);
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % Size;
            }
            return dequeuedRecord;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Queue q1 = new Queue(5);
        String file = "Lab4_Queue/studentin.dat";

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String id, name, dob;
                double cgpa;

                String[] studentData = line.split(",");

                id = studentData[0].trim();
                name = studentData[1].trim();
                dob = studentData[2].trim();
                cgpa = Double.parseDouble(studentData[3].trim());

                q1.enqueue(new Studentinfo(id, name, dob, cgpa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String fileout = "Lab4_Queue/studentout.dat";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileout))) {
            Studentinfo record;
            int count = 1;
            while ((record = q1.dequeue()) != null) {
                writer.write("Dequeued record " + count + ": " + record + "\n");
                System.out.println("Dequeued record " + count + ": " + record);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        scan.close();
    }
}
