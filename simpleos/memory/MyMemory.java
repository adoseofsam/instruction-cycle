package simpleos.memory;
import java.util.*;

public class MyMemory extends Memory {

        public String memstring [];

        public MyMemory(int size){
            super(size);
            memstring = new String[size];
          
        }

        // public MyMemory(){
            
        // }

        public void printSize(){
            System.out.println("The Size of the memory is: " + getSize());
        }
        public void populateMemory(){
            memstring[0] = "0011";
            memstring[1] = "0111";
            memstring[2] = "0001";
            memstring[3] = "0010";
            memstring[4] = "0101";
            memstring[5] = "0100";
            
        }
        public void toDecimal(){
            for(int i = 0; i<super.getSize(); i++){
                memloc[i]= Integer.parseInt(memstring[i],2);
            }
            System.out.println(Arrays.toString(memloc));
        }
        public void toBinary(){
            for(int i = 0; i>super.getSize(); i++){
                memstring[i] = Integer.toBinaryString(memloc[i]);
            }
            System.out.println(Arrays.toString(memstring));

        }
    
}//end abstract class memory
