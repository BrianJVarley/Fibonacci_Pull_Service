package ie.gmit;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FibonacciServer {

	public static void main(String[] args) {
		
		 try{
		      //Create server object
		      FibonacciImplementation fibo = new FibonacciImplementation();
		 
		      //Reference to registry service by creating registry service
		      Registry registry = LocateRegistry.createRegistry(1099);
		 
		      //Register server object to registry with unique name
		      registry.rebind("PowerObject", fibo);
		 
		      System.out.println("Remote server started...");
		    }catch(RemoteException re){
		      re.printStackTrace();
		    }
		  }


}
