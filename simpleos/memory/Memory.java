package simpleos.memory;

import java.util.*;

public abstract class Memory {

    public int memloc [];
    public int size;
    public final int Read_error = 1;
    private int error;

    public Memory(int size){
        System.out.println("Initializing memory size");
        this.size=size;
        memloc = new int[size];
        
    }

    public Memory(){

    }

    public int getSize(){
        return size;
    }

    public int getValue(int index){
        return memloc[index];
        // int value = (int)Array.get(memloc,index);
        // return value;
    //    return (int) Memory.memloc.get(index); 

    }

    public int read(int loc){
        int value = 0;
        if(loc < 0 || loc >= getSize()){
            error = Read_error;
        
        }
        else value = memory[loc];
        return value;
    }

    public int setValue(int index, int value) {
        try{
            memloc[index] = value;
            System.out.println("Value set successfully");
            return 1;

        }catch(Exception e){
            System.out.println(e.toString());
            return -1;
        }
        
    }//set Value

}//end abstract class memory
