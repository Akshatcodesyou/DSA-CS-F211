// package Lab1;
import java.io.*;

class first {
    public static void main(String[] args) {
        File myObj = new File("Lab1/studentout1.dat");
        try {
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
