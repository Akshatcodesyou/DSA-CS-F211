package Lab2_Stack;

import java.io.*;

class Studentinfo{
    String IDNO, NAME, DOB;
    double CGPA;

    public Studentinfo(String IDNO, String NAME, String DOB, double CGPA){
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

public class Stack {
    private Studentinfo[] stackarr;
    private int top;

    public Stack(int size){
        stackarr = new Studentinfo[size];
        top = -1;
    }
    public void push(Studentinfo record) {
        if (top < stackarr.length - 1) {
            stackarr[++top] = record;
        } else {
            System.out.println("Stack Overflow!");
        }
    }
    public Studentinfo pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
            return null;
        } else {
            return stackarr[top--];
        }
    }
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        String file = "Lab2/studentin.dat";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String id, name, dob;
                double cgpa;

                String[] studentData = line.split(",\\s*");

                id = studentData[0].trim();
                name = studentData[1].trim();
                dob = studentData[2].trim();
                cgpa = Double.parseDouble(studentData[3].trim());
                stack.push(new Studentinfo(id, name, dob, cgpa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileout = "Lab2/studentout.dat";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileout))) {
            for(int i = 0; i < stack.stackarr.length; i++) {
                Studentinfo record = stack.pop();
                System.out.println("Popped record " + (i + 1) + ": " + record + "\n");
                if (record != null) {
                    writer.write("Popped record " + (i + 1) + ": " + record + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}