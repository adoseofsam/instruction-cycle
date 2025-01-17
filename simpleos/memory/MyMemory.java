package simpleos.memory;

import java.util.*;
import simpleos.memory.Instruction;

public class MyMemory extends Memory {

    private Instruction instruction;
    private int contents;
    public int input = 0;
    private Memory memory;


    public MyMemory(int size){
        super(size);
        printSize();
        populateMemory();
    }

    public MyMemory(){
        super();
        this.instruction = new Instruction();
        
    }
    public Instruction getInstruction(){
        return this.instruction;
    }
    public void add(){
        this.contents++;
    }

    public void Data(int contents){
        this.contents = contents;
    }


    public int getContents(){
        return this.contents;
    }
    

    public int toBinary(int decimal){
        int binary = 0;
        int r_val;
        int val = 0;
        if(decimal <= 1){
            return decimal;
        }
        while (decimal > 0){
            r_val = decimal%2;
            decimal = (int)Math.floor(decimal/2);
            binary += r_val*(int)Math.pow(10,val);
            val++;
        }
        return binary;
        // val2 = (int)Math.floor((Math.log10(decimal)/Math.log10(2)));
        // while (decimal > 0){
        //     val += Math.pow(10,val2);
        //     decimal-=Math.pow(2,val2);
        //     val2 = (int)Math.floor((Math.log10(decimal)/Math.log10(2)));
        // }
        // string = "0"+String.valueOf(val);
        // return(string);
    }

    public int toDecimal(int binary){
        int expo = 0;
        int last = 0;
        int decimal = 0;
        while(true)
        {
            if (binary == 0)
            {
                break;
            }
            else
            {
                last = binary%10;
                decimal+= last*Math.pow(2, expo);
                binary = binary/10;
                expo++;
            }
        }
        return decimal;
    }

    public void populateMemory(){
        memloc[0] = toBinary(30);  
        memloc[1] = toBinary(7);
        memloc[2] = toBinary(20);
        memloc[3] = toBinary(30);
        memloc[4] = toBinary(21);
        memloc[5] = toBinary(11);
        memloc[6] = toBinary(5);
        memloc[7] = toBinary(7);
        memloc[8] = toBinary(21);
        memloc[9] = toBinary(4);
        memloc[10] = toBinary(21);
        memloc[11] = toBinary(43);
    }

   

    public void printSize(){
        System.out.println("The Size of the memory is: " + getSize());
    }
}//end abstract class memory
