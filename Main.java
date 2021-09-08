import java.util.Scanner;
import java.io.*;

class Ranger{
    Scanner myObj = new Scanner(System.in);
    public void userInput(){
        System.out.println("Enter first integers to form a range. no negative or floating numbers. Enter two zero's to exit");
        int fnum = myObj.nextInt();
        System.out.println("Enter second integers to form a range. no negative or floating numbers. Enter two zero's to exit");
        int snum = myObj.nextInt();
        checker(fnum, snum);
    }
    public void checker(int fnum, int snum){
        if (snum <= fnum) {
            System.out.println("Endpoint is less than start");
            userInput();    
        }
        else if (fnum < 0 || snum < 0) {
            System.out.println("Numbers are negative");
            userInput();
        }
        else if (fnum == 0 && snum == 0){
            System.out.println("Range is zero to zero. Program Terminated");
        }
        else {
            looper(fnum, snum);
        }
    }

    public void looper(int fnum, int snum) {
        try{
            BufferedWriter bw = new BufferedWriter(
                new FileWriter("Results2.txt"));
            int[] numbers = new int[100];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    int min = fnum;
                    int max = snum;
                    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
                    numbers[(i*10)+j] = random_int;
                }
                int sum = 0;
                int square = 0;
                double stdev = 0; 
                double mean = 0;
                bw.write("Values: ");
                for (int k = 0; k < 10*(i+1); k++) {
                    bw.write(numbers[k] + " ");
                    sum += numbers[k];
                }
                bw.write("\n");
                mean = sum / (10*(i+1));
                for (int k = 0; k < 10*(i+1); k++) {
                    square += Math.pow((numbers[k]-mean), 2);
                }
                stdev = Math.sqrt(square/(10*(i+1)));
                bw.write("Mean: " + mean + " Standard Deviation: " + stdev + "\n");
            }
            bw.close();
        }catch(Exception ex) {
            return;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Ranger myRanger = new Ranger();
        myRanger.userInput();
    }
}