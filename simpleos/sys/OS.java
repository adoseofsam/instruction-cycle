package simpleos.sys;

import simpleos.memory.*;
import simpleos.processor.*;


public class OS {

    public static void main(String[] args){

        try {
            final int size = 100;
            Message msg = new Message();
            msg.display();
            MyMemory m = new MyMemory(size);
            MyProcessor p = new MyProcessor();
            
            Thread.sleep(1000);
            // m.printSize();
            p.fetch();            
			Thread.sleep(2000);
            p.execute();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }// End man method

}// END class OS
