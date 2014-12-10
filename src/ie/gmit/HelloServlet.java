package ie.gmit;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	int fibNum;
	
	//parse input from hello.jsp input box 
	//and assign to fibNum variable
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		// read form fields
        String fibNum = req.getParameter("fibNum");
        //print input from home page
        System.out.println("Input: " + fibNum);
        
        
        
        
        try{
		      //Get reference from server's registry
		      Registry registry = LocateRegistry.getRegistry("127.0.0.1");
		 
		      //Lookup server object from server's registry
		      IFibonacci fibonacci_proxy = (IFibonacci)registry.lookup("PowerObject");
		      
		      /*
		      //get user input 
		      Scanner user_input = new Scanner(System.in);
		      String fibMaxNum;
		            
		      System.out.println("Enter the highest fibonacci number: ");
		      fibMaxNum = user_input.next();
		      
		       */
		      int fibMax = Integer.parseInt(fibNum);
		      
		   
		      
		     //Invoke server object's methods 
		     //Get Fibonacci array.
		  	 int[] Fibsequence = fibonacci_proxy.fibonacciArrayTest(fibMax);
		  	 for (int value : Fibsequence) {
			    System.out.println(value);
		  	 }
		  	 
		  	 	
		      
		    }catch(NotBoundException nbe){
		      nbe.printStackTrace();
		    }catch(RemoteException re){
		      re.printStackTrace();
		    }
		
            //send input to the result page using a redirect
            resp.sendRedirect(("result.jsp?fibNum=" + fibNum));	
		  }
        
}
