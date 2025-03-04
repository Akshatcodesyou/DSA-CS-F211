// package Lab1;

import java.io.*;

class second {
    public static void main(String[] args) {
        File myObj = new File("Lab1/studentout1.dat");
        try (FileWriter write = new FileWriter(myObj, true)) {
            write.append("Implemting data Structures would be fun");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
