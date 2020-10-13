package simpleos.processor;

import simpleos.memory.*;


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
    private final int halt = 8;
    private boolean didhalt;


    public MyProcessor(){
    this.PC = new MyMemory();//initialize program counter of size 1
    this.IR = new MyMemory();//initialize instruction register of size 8
    this.ACC = new MyMemory(); //initialize accumulator of size 8
    this.PC.setValue(0,0); //sets program counter to 0
    this.didhalt = false;
    this.memory = memory;
    }

    public int fetch(){
        
        if (this.didhalt)return false;
        int address = this.PC.getContents();
        int ir = memory.getValue(address);
        if(ir == address){
            this.IR.setValue(0,ir);
            this.PC.add();
            System.out.println("Processor is now fetching..");
            return 1;
        }
        return 0;
       

    } 
    public int execute(){
        System.out.println("Processor is now execting..");
        return 1;
    } 

} //end abstract class Processor
