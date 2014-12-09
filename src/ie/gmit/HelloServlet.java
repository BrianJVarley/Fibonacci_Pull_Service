package ie.gmit;

import java.io.IOException;

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
        
        //send input to the result page using a redirect
        resp.sendRedirect(("result.jsp?fibNum=" + fibNum));
        
	}
	

}
