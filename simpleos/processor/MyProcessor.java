package simpleos.processor;

import simpleos.memory.*;
import java.util.*;
import java.lang.String;


public  class MyProcessor extends Processor {

    private MyMemory PC;    
    private MyMemory IR;    
    private MyMemory ACC; //store computations
    private int size;
    private MyMemory memory;
    private final int load = 1;
    private final int loadin = 3;
    private final int store = 2;
    private final int storeout = 7;
    private final int add = 5;
    private final int subtract = 4;
    private final int halt = 43;
    private boolean didhalt;



    public MyProcessor(){
        this.PC = new MyMemory(1);//initialize program counter of size 1
        this.IR = new MyMemory(8);//initialize instruction register of size 8
        this.ACC = new MyMemory(8); //initialize accumulator of size 8
        this.PC.setValue(0,0); //sets program counter to 0
        // memoryprocess = memory;
        // this.memory = new MyMemory(8);
    }
    // This method fetches instruction at address in memory specified by PC and places it into the IR(instruction register)
    public int fetch(){//not working
        // int addr = this.PC.getValue(0);
        // int addr = (int)Array.get(memory.memloc,0); 
        int addr = this.PC.memloc[0];//not working. addr takes values of pc
        int ir = this.IR.setValue(0,addr);
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
        switch (key) {
            case value:
                
                break;
        
            default:
                break;
        }
        // fetch();
        // char operation;
        // int ac = 0;
        // // //add if statements for opcode in order to carry out instructions
        // for(int i = 0; i<memory.getSize(); i++){
        //     if (memory.memloc[i] == 7){
        //         ac = memory.memloc[i];
        //         System.out.print(ac);
        //     }
        // }
                
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
