package ie.gmit;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFibonacci extends Remote {

	
	//Declare available methods and must throw RemoteException
	  long fibonacci(int fibMax) throws RemoteException;
	  
	  
	  int[] fibonacciArrayTest(int fibMax) throws RemoteException;
	
}
