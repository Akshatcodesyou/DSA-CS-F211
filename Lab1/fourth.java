// package Lab1;
import java.io.*;
import java.util.*;
class fourth {
    public static void main(String[] args) {
        File myObj = new File("Lab1/studentout1.dat");
        File myObj2 = new File("Lab1/studentout2.dat");
        try {
            myObj2.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Scanner read = new Scanner(myObj);
            while(read.hasNextLine()){
                String data = read.nextLine();
                try(FileWriter write = new FileWriter(myObj2, true)){
                    write.append(data+"\n");
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }
    }
}
