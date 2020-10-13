package simpleos.memory;

public class Instruction{
    private int instruction_bits;
    private int address_bits;
    private static final int maxcode = 2;
    private MyMemory memory;


    public Instruction(int instruction_bits, int address_bits){
        this.instruction_bits=instruction_bits;
        this.address_bits = address_bits;
    }

    public Instruction(){

    }

    public int getInstruction(int value){
        int totalint = 1 + (int) Math.log10(value);
        if (totalint <= maxcode ) return 0;
        int expo = totalint - maxcode;
        int power = (int) Math.pow(10, expo);
        int operationcode = value/ power;
        int op = memory.toBinary(operationcode);
        return op;
        // return this.instruction_bits;
    }

    public int getAddress(int value){
        int totalint = 1 + (int) Math.log10(value);
        if (totalint <= maxcode) return value;
        int expo = totalint - maxcode;
        int power = (int) Math.pow(10, expo);
        int addr = value % power;
        memory.toBinary(addr);
        return addr;
    }

    
}