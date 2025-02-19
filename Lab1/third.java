// package Lab1;

import java.io.*;
import java.util.*;

class third {
    public static void main(String[] args) {
        File myObj = new File("Lab1/studentout1.dat");
        Scanner scan = new Scanner(System.in);
        for(int i = 0; i < 3; i++){
            System.out.println("Enter input " + (i+1) + " :");
            String inp = scan.nextLine();
            try(FileWriter write = new FileWriter(myObj, true)){
                write.append("\n" + inp);
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        scan.close();
    }
}
