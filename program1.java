
// Java program to demonstrate BufferedReader
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileWriter;



class Sorter {

    String userInput;
    String orderedString;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Sorter()throws IOException{
        read();
        sort();
        write();
        writeToFile();
    }
    
    void read() throws IOException{
        System.out.println("Enter name: ");
        userInput = br.readLine(); 
    }

    void sort(){
        char a[] = userInput.toCharArray();
        Arrays.sort(a);
        orderedString = new String(a);
    }

    void write()throws IOException{
        System.out.println("Name in alphabetical order: ");
        System.out.println(orderedString);
    }

    void writeToFile()throws IOException{
        FileWriter fw = new FileWriter("Results1.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(userInput);
        bw.write(" ,");
        bw.write(orderedString);
        bw.newLine();
        bw.close();
    }

    public static void main(String[] args) throws IOException
    {
        Sorter studentName1 = new Sorter();
        Sorter studentName2 = new Sorter();
        Sorter studentName3 = new Sorter();
    }
}