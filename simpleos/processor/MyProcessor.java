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
        this.IR = new MyMemory(7);//initialize instruction register of size 1
        this.ACC = new MyMemory(7); //initialize accumulator of size 8
        // this.PC.setValue(0,3); //sets program counter to 2
        // this.memory = new MyMemory(8);
    }
    // This method fetches instruction at address in memory specified by PC and places it into the IR(instruction register)
    public int fetch(){
        int address = this.PC.getValue(0);
        // int address = this.PC.memloc[0];
        
        System.out.println("Processor is now fetching.."+address);
        return address;
 
        // }
        // catch (NullPointerException e) { 
        //     System.out.println("Exception thrown : " + e); 
        // } 
    }

    //This method takes the value from address location and loads it into the accumulator
    public int execute(){
        System.out.println("Processor is now execting..");
        return 1;
    } 
    //This method will generate the fib series using the above methods
    // public int[]fibseries{
    // }

} //end abstract class Processor
