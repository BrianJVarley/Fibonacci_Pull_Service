package ie.gmit;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FibonacciServlet extends HttpServlet {
	
	//Version number for serialization runtime 
	private static final long serialVersionUID = 1L;
	
	private int[]  fibSequence;
	
	//
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// read form fields
        String fibNum = req.getParameter("fibNum");
       
      
        try{
		      //Get reference from server's registry
		      Registry registry = LocateRegistry.getRegistry("127.0.0.1");
		 
		      //Lookup server object from server's registry
		      IFibonacci fibonacci_proxy = (IFibonacci)registry.lookup("PowerObject");
		      
		 
		      int fibMax = Integer.parseInt(fibNum);
		         
		     //Invoke server object's methods 
		     //Get Fibonacci array.
		      fibSequence = fibonacci_proxy.fibonacciArrayTest(fibMax);
		  	 
		  	 
		  	 for (int value : fibSequence) {
			    System.out.println(value);
		  	 }
		  	 
		  	 
		  	System.out.println(Arrays.toString(fibSequence));
		  	
		  	 	    
		    }catch(NotBoundException nbe){
		      nbe.printStackTrace();
		    }catch(RemoteException re){
		      re.printStackTrace();
		    }
		
            //send input to the result page using a redirect
            //resp.sendRedirect(("result.jsp?fibNum=" + fibNum));
            resp.sendRedirect(("result.jsp?fibSequence=" + fibSequence)); 
           
		  }
        
}
