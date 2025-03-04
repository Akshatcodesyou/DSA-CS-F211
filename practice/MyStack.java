import java.io.*;

//java program to implement stack using array

public class MyStack {
    class Stack{
        private Studentrec[] list;
        private int top;
        Stack(int size){
            list = new Studentrec[size];
            this.top = -1;
        }
        public boolean isEmpty(){
            return this.list.length == 0;
        }
        public void push(Studentrec record){
            if (top == list.length - 1) {
                System.out.println("Stack is full");
            } else {
                list[++top] = record;
            }
        }
        public Studentrec pop(){
            if(this.isEmpty()){
                System.out.println("Stack is empty");
                return null;
            }else{
                Studentrec record = list[top];
                list[top] = null;
                top--;
                return record;
            }
        }
    }
    class Studentrec{
        String IDNO, NAME, DOB;
        double CGPA;
        Studentrec(String IDNO, String NAME, String DOB, double CGPA){
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
    public static void main(String[] args) {
        MyStack myStack = new MyStack(); //need to make an instance of the main class 
        Stack s = myStack.new Stack(5); //then make an instance of the defined stack class
        String file = "Lab2/studentin.dat"; //replace this with your file location
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
                s.push(myStack.new Studentrec(id, name, dob, cgpa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileout = "Lab2/studentout.dat";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileout))) {
            for(int i = 0; i < s.list.length; i++) {
                Studentrec record = s.pop();
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
