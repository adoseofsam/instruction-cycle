package simpleos.sys;

import simpleos.memory.*;
import simpleos.processor.*;
import java.util.Arrays;

/*Driver code to execute simpleos*/
public class OS {

    public static void main(String[] args){

        try {
            Message msg = new Message(); //instance of message class is created
            msg.display();  //method to display welcome message
            Thread.sleep(2000); //"stops the program"
            MyMemory m = new MyMemory(12); //instace of MyMemory class is created
            MyProcessor p = new MyProcessor(m); //instance of MyProcessor class is created linking to memory
            System.out.println(Arrays.toString(m.memloc)); 
            Thread.sleep(1000);
            // m.printSize();
            p.fetch();     //call to fetch method from MyProcessor class       
			Thread.sleep(2000);
            p.execute(); //call to execute method from MyProcessor class
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }// End main method

}// END class OS
