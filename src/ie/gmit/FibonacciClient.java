package ie.gmit;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class FibonacciClient {

	public static void main(String[] args) {
		
		try{
		      //Get reference from server's registry
		      Registry registry = LocateRegistry.getRegistry("127.0.0.1");
		 
		      //Lookup server object from server's registry
		      IFibonacci fibonacci_proxy = (IFibonacci)registry.lookup("PowerObject");
		      
		      //get user input 
		      Scanner user_input = new Scanner(System.in);
		      String fibMaxNum;
		            
		      System.out.println("Enter the highest fibonacci number: ");
		      fibMaxNum = user_input.next();
		      
		      
		      int fibMax = Integer.parseInt(fibMaxNum);
		      
		    
		    //Invoke server object's methods 
		      //Get Fibonacci array.
		  	 int[] sequence = fibonacci_proxy.fibonacciArrayTest(fibMax);
		  	 for (int value : sequence) {
			    System.out.println(value);
		  	 }
		  	 
		  	 	
		      
		    }catch(NotBoundException nbe){
		      nbe.printStackTrace();
		    }catch(RemoteException re){
		      re.printStackTrace();
		    }
		
				
		  }
			
}

