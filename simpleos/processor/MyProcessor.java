package simpleos.processor;

import simpleos.memory.*;
public  class MyProcessor extends Processor {

    private MyMemory PC;    
    private MyMemory IR;   //stores address
    private MyMemory ACC; //store computations
    private MyMemory memory; //MyMemory instance is created
    private String fibseries =""; //variable that will store the fibonacci sequence
    //Load/Store operations; 
    private final int load = 10;
    private final int loadin = 3;
    private final int store=21;;
    private final int storeout= 7;
    //Arithmetic Operations
    private final int add=5;
    private final int subtract=31;;
    //Transfer-of-control operations
    private final int halt=43;;
    private boolean didhalt;

    /*This is the constructor for the MyProcessor class.It takes in as parameter an instance of Mymemory 
    ,initializes the registers and create sets the value of the PC */
    public MyProcessor(MyMemory m){
    this.PC = new MyMemory();//initialize program counter 
    this.IR = new MyMemory();//initialize instruction register 
    this.ACC = new MyMemory(); //initialize accumulator 
    this.PC.setValue(0,0); //sets program counter to 0
    this.didhalt = false;
    this.memory = m;
    }

    /*This function fetches instruction at specified address in memory
    and puts it/loads it into the instruction register*/
    public int fetch(){
        // if (this.didhalt)return false;
        int address = this.PC.getValue(0); //gets the address of the instruction at this location in memory
  
            this.IR.setValue(0,address); //stores it into the IR
            address++;   //increments program counter
            System.out.println("Processor is now fetching..");
            // return 1;
        
        return 0;
       

    } 
    /*This function is used to take the value from the address location, loads it into the 
    Accumulator and performs the action specified by the operation code.*/
    
    public int execute(){
        int acc;
        int memory_value;
        int num;
        Instruction ir = this.IR.getInstruction();
        int addr;
        int opcode= memory.toDecimal(ir.getInstruction()); //opcode 

        switch (opcode) {
            case load:
            //Loads accumulator contents into memory
                addr = memory.toDecimal(ir.getAddress());
                memory_value = this.memory.getValue(addr);
                this.ACC.read(memory_value);
                break;
            case store:
            //Stores accumulator contents into memory
                addr = memory.toDecimal(ir.getAddress());
                acc = this.ACC.getContents();
                this.memory.setValue(addr,acc);
                break;
            case loadin:
            //loads standard input to accumulator
                int value = memory.input;
                memory.input++;
                this.ACC.Data(memory.input);
                break;
            case subtract:
            //substract accumulator contents from memory 
                addr = memory.toDecimal(ir.getAddress());
                memory_value = memory.getValue(addr);
                acc = this.ACC.getContents();
                num = acc - memory_value;
                this.ACC.Data(num);
                break;
            case add:
            //add to accumulator from memory
                addr = memory.toDecimal(ir.getAddress());
                memory_value = this.memory.getValue(addr);
                acc = this.ACC.getContents();

                num = acc + memory_value;
                this.ACC.Data(num);
                break;
            case storeout:
            //store accumulator content to standard output
                acc = this.ACC.getContents();
                this.fibseries += acc;
                break;
            case halt:
                // Halt the CPU
                this.fibseries+="";
                didhalt = true;
            default:
                System.out.println("Unrecognized Opcode");
                break;
        }

        
        System.out.println("Processor is now execting..");
        return 1;
    } 
    /*This method is used to output the fibonacci series*/
    public String Fibseries(){
        return this.fibseries;
    }

} //end abstract class Processor