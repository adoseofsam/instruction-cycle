package simpleos.memory;
import java.util.*;

public abstract class Memory {

    public int memloc [];
    int size;

    public Memory(){

    }

    public Memory(int size){
        System.out.println("Initializing memory size");
        this.size=size;
        memloc = new int[size];
    }

    public int getSize(){
        return size;
    }

    public int getValue(int index){ //gets the value in memory at index specified
       return memloc[index]; 
    }


    //sets a value at index specified
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
