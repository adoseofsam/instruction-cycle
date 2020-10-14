package simpleos.processor;

import simpleos.memory.*;
public  class MyProcessor extends Processor {

    private MyMemory PC;    
    private MyMemory IR;   //stores address
    private MyMemory ACC; //store computations
    private MyMemory memory; //MyMemory instance is created
    private String fibseries =""; //variable that will store the fibonacci sequence
    //Load/Store operations; 
    private final int load;
    private final int loadin;
    private final int store;
    private final int storeout;
    //Arithmetic Operations
    private final int add;
    private final int subtract;
    //Transfer-of-control operations
    private final int halt;
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
        int ir = memory.getValue(address); 
        if(ir == address){    //check to see if the values are the same
            this.IR.setValue(0,ir); //store it into the IR
            address++;   //increments program counter
            System.out.println("Processor is now fetching..");
            return 1;
        }
        return 0;
       

    } 
    public int execute(){
        int acc;
        int memory_value;
        int num;
        Instruction ir = this.IR.getInstruction();
        int addr;
        int opcode= memory.toDecimal(ir.getInstruction());

        switch (opcode) {
            case load:
                addr = memory.toDecimal(ir.getAddress());
                memory_value = this.memory.getValue(addr);
                this.ACC.read(memory_value);
                break;
            case store:
                addr = memory.toDecimal(ir.getAddress());
                acc = this.ACC.getContents();
                this.memory.setValue(addr,acc);
                break;
            case loadin:
                int value = memory.input;
                memory.input++;
                this.ACC.Data(memory.input);
                break;
            case subtract:
                addr = memory.toDecimal(ir.getAddress());
                memory_value = memory.getValue(addr);
                acc = this.ACC.getContents();
                num = acc - memory_value;
                this.ACC.Data(num);
                break;
            case add:
                addr = memory.toDecimal(ir.getAddress());
                memory_value = this.memory.getValue(addr);
                acc = this.ACC.getContents();

                num = acc + memory_value;
                this.ACC.Data(num);
                break;
            case storeout:
                acc = this.ACC.getContents();
                this.fibseries += acc;
                break;
            case halt:
                this.fibseries+="";
                return 0;
            default:
                System.out.println("Unrecognized Opcode");
                break;
        }

        
        System.out.println("Processor is now execting..");
        return 1;
    } 
    public String Fibseries(){
        return this.fibseries;
    }

} //end abstract class Processor