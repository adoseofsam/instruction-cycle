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

    public void Mutint(Instruction instruction){
        this.instruction = instruction;
    }

    public int getContents(){
        return this.contents;
    }

    public void Contents(int contents){
        this.contents = contents;
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
        int index = 0;
        int instruct;
        int middle = (int)Math.floor(size/2);
        int addr = middle;
        memloc[0] = toBinary(3);  
        memloc[1] = toBinary(7);
        memloc[2] = toBinary(2);
        memloc[3] = toBinary(3);
        memloc[4] = toBinary(2);
        memloc[5] = toBinary(1);
        memloc[6] = toBinary(5);
        memloc[7] = toBinary(7);
        memloc[8] = toBinary(2);
        memloc[9] = toBinary(4);
        memloc[10] = toBinary(2);
        memloc[11] = toBinary(8);
    }

    

    //     instruct = toBinary(3);
    //     // addr = toBinary(addr);
    //     instruction = new Instruction(instruct,toBinary(addr));
    //     Memory.memloc.setValue(index,instruction);

    //     instruct = toBinary(7);
    //     // addr = toBinary(addr);
    //     instruction = new Instruction(instruct,toBinary(addr));

    //     instruct = toBinary(2);
    //     // addr = toBinary(addr);
    //     instruction = new Instruction(instruct,toBinary(addr));

    //     instruct = toBinary(3);
    //     // addr = toBinary(addr);
    //     instruction = new Instruction(instruct,toBinary(addr));

    //     instruct = toBinary(2);
    //     // addr = toBinary(addr);
    //     instruction = new Instruction(instruct,toBinary(addr));


        

    // }

   

    public void printSize(){
        System.out.println("The Size of the memory is: " + getSize());
    }
}//end abstract class memory
