package simpleos.processor;

import simpleos.memory.*;


public  class MyProcessor extends Processor {

    private MyMemory PC;    
    private MyMemory IR;    
    private MyMemory ACC; //store computations
    private int size;
    private MyMemory memory;
    private String fibseries ="";
    private final int load = 11;
    private final int loadin = 30;
    private final int store = 21;
    private final int storeout = 7;
    private final int add = 5;
    private final int subtract = 4;
    private final int halt = 43;
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
        // if (this.didhalt)return false;
        int address = this.PC.getValue(0);
        int ir = memory.getValue(address);
        if(ir == address){
            this.IR.setValue(0,ir);
            address++;
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