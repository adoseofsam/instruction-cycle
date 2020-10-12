package simpleos.sys;

import simpleos.memory.*;
import simpleos.processor.*;
import java.util.Arrays;


public class OS {

    public static void main(String[] args){

        try {
            MyMemory m = new MyMemory(6);
            MyProcessor p = new MyProcessor();
            
            m.populateMemory();
            m.printSize();
            System.out.println("Contents in memory: "+Arrays.toString(m.memstring));
            // for(int i = 0; i<m.getSize(); i++){
            //     System.out.println(m.memloc[i]);
            // }
            System.out.println("Contents are now being converted and stored...");
            m.toDecimal();
            // System.out.println(m.getValue(3));
            // m.toBinary();
            p.fetch();            
			Thread.sleep(2000);
            p.execute();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }// End man method

}// END class OS
