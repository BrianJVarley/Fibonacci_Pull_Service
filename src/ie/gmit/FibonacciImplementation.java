package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.server.ServerNotActiveException;
import java.rmi.server.UnicastRemoteObject;

public class FibonacciImplementation extends UnicastRemoteObject implements IFibonacci{

	//Throw RemoteException on constructor
	  public FibonacciImplementation() throws RemoteException{
	 
	  }
	 
	  //Overwrite IPower interface
	  public long fibonacci(int n) throws RemoteException{
	    //Log connection from a client
	    try {
	      System.out.println("Got invocation from " + getClientHost());
	    } catch (ServerNotActiveException ex) {
	      ex.printStackTrace();
	    }
	 
	    return calculateFibonacci(n);
	  }
	 
	  
	  //Fibonacci calculation
	  private long calculateFibonacci(int n){
	    if (n == 0) {
	      return 0L;
	    }
	    if (n == 1) {
	      return 1L;
	    }
	 
	    return (calculateFibonacci(n - 1) + calculateFibonacci(n - 2));
	  }

	
	
	public int[] fibonacciArrayTest(int n) {
		int a = 0;
		int b = 1;
		int[] sequence = new int[n];

		// Fill array with Fibonacci values.
		for (int i = 0; i < n; i++) {
		    sequence[i] = a;

		    int temp = a;
		    a = b;
		    b = temp + b;
		}
		return sequence;
	    }
	 
	 
}
