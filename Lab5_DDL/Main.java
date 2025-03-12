package Lab5_DDL;

import java.util.Scanner;

class Student{
    String name;
    int id;
    String branch;
    double cgpa;
    Student prev, next;

    public Student(String name, int id, String branch, double cgpa){
        this.name = name;
        this.id = id;
        this.branch = branch;
        this.cgpa = cgpa;
        this.prev = null;
        this.next = null;
    }
}

class DLL{
    private Student head, tail;

    public DLL(){
        head = null;
        tail = null;
    }

    public void add(String name, int id, String branch, double cgpa){
        Student newStd = new Student(name, id, branch, cgpa);
        if (head == null){
            head = tail = newStd;
        }
        else{
            Student cur = head;
            while (cur != null && cur.id < id){
                cur = cur.next;
            }
            if (cur == head){
                newStd.next = head;
                head.prev = newStd;
                head = newStd;
            }
            else if (cur == null){
                tail.next = newStd;
                newStd.prev = tail;
                tail = newStd;
            }
            else{
                newStd.prev = cur.prev;
                newStd.next = cur;
                cur.prev.next = newStd;
                cur.prev = newStd;
            }
        }
        System.out.println("Addition Success!");
    }

    public void del(int id){
        Student cur = head;
        while (cur != null && cur.id != id){
            cur = cur.next;
        }
        if (cur == null){
            System.out.println("Student not found.");
            return;
        }
        if (cur == head){
            head = cur.next;
            if (head != null) head.prev = null;
        }
        else if (cur == tail){
            tail = cur.prev;
            tail.next = null;
        }
        else{
            cur.prev.next = cur.next;
            cur.next.prev = cur.prev;
        }
        System.out.println("Deletion Success!");
    }

    public void search(int id){
        Student cur = head;
        while (cur != null && cur.id != id){
            cur = cur.next;
        }
        if (cur != null){
            System.out.println("\tStudent details are:");
            System.out.println("Name: " + cur.name);
            System.out.println("IDNO: " + cur.id);
            System.out.println("Branch: " + cur.branch);
            System.out.println("Cgpa: " + cur.cgpa);
        }
        else{
            System.out.println("Student not found.");
        }
    }

    public void displayAll(){
        if (head == null){
            System.out.println("No students in the list.");
            return;
        }
        
        Student cur = tail;
        System.out.println("All Students' details are:");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Name", "IDNO", "BRANCH", "CGPA");
        System.out.println("===============================");
        
        while (cur != null){
            System.out.printf("%-20s %-10d %-10s %-10.2f%n", 
                              cur.name, cur.id, cur.branch, cur.cgpa);
            cur = cur.prev;
        }
    }

    public void bestPerformer(){
        if (head == null){
            System.out.println("No students in the list.");
            return;
        }

        Student best = head;
        Student cur = head.next;

        while (cur != null){
            if (cur.cgpa > best.cgpa){
                best = cur;
            }
            cur = cur.next;
        }

        System.out.println("\tBest performer details are:");
        System.out.println("Name: " + best.name);
        System.out.println("IDNO: " + best.id);
        System.out.println("Branch: " + best.branch);
        System.out.println("Cgpa: " + best.cgpa);
    }
}

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DLL dll = new DLL();
        
        int choice;

        do{
            System.out.println("Options: ");
            System.out.println("1. Add student");
            System.out.println("2. Delete student");
            System.out.println("3. Search Student");
            System.out.println("4. Display all");
            System.out.println("5. Best performer");
            System.out.println("6. Exit");
            
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch (choice)
            {
                case 1:
                    System.out.println("Enter name: ");
                    String name = sc.next();
                    System.out.println("Enter IDNO: ");
                    int id = sc.nextInt();
                    System.out.println("Enter Branch: ");
                    String branch = sc.next();
                    System.out.println("Enter CGPA: ");
                    double cgpa = sc.nextDouble();
                    dll.add(name, id, branch, cgpa);
                    break;

                case 2:
                    System.out.println("Enter IDNO of student to delete: ");
                    int delId = sc.nextInt();
                    dll.del(delId);
                    break;

                case 3:
                    System.out.println("Enter IDNO of student to search: ");
                    int searchId = sc.nextInt();
                    dll.search(searchId);
                    break;

                case 4:
                    dll.displayAll();
                    break;

                case 5:
                    dll.bestPerformer();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
            System.out.println();
        }
        while (choice != 6);

        sc.close();
    }
}