package Lab2_Stack;

import java.util.*;
import java.io.*;

class first {
    private arr[] stack;
    String IDNO, NAME, DOB;
    double CGPA;

    first(String IDNO, String NAME, String DOB, double CGPA) {
        this.IDNO = IDNO;
        this.NAME = NAME;
        this.DOB = DOB;
        this.CGPA = CGPA;
    }

    public void display() {
        System.out.println("ID: " + IDNO);
        System.out.println("Name: " + NAME);
        System.out.println("DOB: " + DOB);
        System.out.println("CGPA: " + CGPA);
        System.out.println("-------------------------");
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Stack<first> stack = new Stack<>();

        String fileName = "Lab2/studentin.dat";

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String id, name, dob;
                    double cgpa;

                    String[] studentData = line.split(",\\s*");
    
                    id = studentData[0].trim();
                    name = studentData[1].trim();
                    dob = studentData[2].trim();
                    cgpa = Double.parseDouble(studentData[3].trim());

                    stack.push(new first(id, name, dob, cgpa));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        System.out.println("\nStudent Details (popped from the stack):");
        while (!stack.isEmpty()) {
            first student = stack.pop();
            student.display();
        }

        scan.close();
    }
}
