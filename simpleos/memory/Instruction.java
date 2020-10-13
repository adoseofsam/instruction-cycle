package simpleos.memory;

public class Instruction{
    private int instruction_bits;
    private int address_bits;


    public Instruction(int instruction_bits, int address_bits){
        this.instruction_bits=instruction_bits;
        this.address_bits = address_bits;
    }

    public Instruction(){

    }

    public int getInstruction(){
        return this.instruction_bits;
    }

    public int getAddress(){
        return this.address_bits;
    }

    
}