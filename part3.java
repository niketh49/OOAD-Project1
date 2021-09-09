import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.FileWriter;



class ASCII {

    String userInput;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    ASCII()throws IOException{
        read();
        writeToFile();

    }
    
    void read() throws IOException{
        System.out.println("Enter string: ");
        userInput = br.readLine(); 
    }

    void writeToFile()throws IOException{
        FileWriter fw = new FileWriter("Results3.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        String [] input=userInput.split(",");
        int a=0;
        for(String str1 :  input){
            a=Integer.parseInt(str1);
            if(a>=97 && a<=122){
                bw.write("Code:"+a+"  Type: Lower case"+"  ASCII Char: "+(char)a);
                bw.newLine();
            }
            else if(a>=65 && a<=90){
                bw.write("Code:"+a+"  Type: Upper case"+"  ASCII Char: "+(char)a);
                bw.newLine();
            }
            else if(a>=48 && a<=57){
                bw.write("Code:"+a+"  Type: Digit"+"  ASCII Char: "+(char)a);
                bw.newLine();
            }
            else if((a>=33 && a<=47)||(a>=58 && a<=64)||(a>=91 && a<=96)||(a>=123 && a<=126)){
                bw.write("Code:"+a+"  Type: Special Character"+"  ASCII Char: "+(char)a);
                bw.newLine();
            }
            else{
                //outputed the name of the character for the values tested in the string but ingeneral i just output the char of that value inputed
                if(a==32){
                    bw.write("Code:"+a+"  Type: White space"+"  ASCII Char: [space]");
                    bw.newLine();
                }
                else if(a==7){
                    bw.write("Code:"+a+"  Type: White space"+"  ASCII Char: [bell]");
                    bw.newLine();
                }
                else if(a==9){
                    bw.write("Code:"+a+"  Type: White space"+"  ASCII Char: [tab]");
                    bw.newLine();
                }
                else{
                    bw.write("Code:"+a+"  Type: White space"+"  ASCII Char: "+(char)a);
                    bw.newLine();
                }
            }

        }
        bw.close();
    }

    public static void main(String[] args) throws IOException
    {
        ASCII asci = new ASCII();
    }
}











