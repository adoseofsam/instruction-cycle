package simpleos.processor;

import simpleos.memory.*;
import java.util.*;
import java.lang.String;


public  class MyProcessor extends Processor {

    private MyMemory PC;    
    private MyMemory IR;    
    private MyMemory ACC; 
    private int size;
    private MyMemory memory = new MyMemory();



    public MyProcessor(){
        this.PC = new MyMemory(1);//initialize program counter of size 1
        this.IR = new MyMemory(8);//initialize instruction register of size 8
        this.ACC = new MyMemory(8); //initialize accumulator of size 8
        this.PC.setValue(0,0); //sets program counter to 0
        // this.memory = new MyMemory(8);
    }
    // This method fetches instruction at address in memory specified by PC and places it into the IR(instruction register)
    public int fetch(){//not working
        // int addr = this.PC.getValue(0);
        // int addr = (int)Array.get(memory.memloc,0); 
        int addr = this.PC.memloc[0];//not working. addr takes values of pc
        System.out.println(addr);
        System.out.println("Processor is now fetching...");
        return addr;
        // System.out.println("Adding address to instruction register");
        // int ir = this.IR.setValue(0,addr);
        // return addr;
 
        // // }
        // // catch (NullPointerException e) { 
        // //     System.out.println("Exception thrown : " + e); 
        // // } 
    }

    //This method takes the value from address location and loads it into the accumulator
    public int execute(){
        // fetch();
        // char operation;
        // //add if statements for opcode in order to carry out instructions
        // for(int i = 0; i<memstring.getSize(); i++){
        //     if memstring[i].equals("0101"){
                
        //     }
        //     elif
        // }

        System.out.println("Processor is now executing..");
        return 1;
    } 
    //This method will generate the fib series using the above methods
    // public int[]fibseries{
    // }

} //end abstract class Processor
