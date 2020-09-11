package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaInventoryConsumer extends HttpServlet{
	// get and keep a reference of the shared PizzaInventory
	
	private PizzaInventory inventory =PizzaInventory.getInstance();
	
	public void doGet(HttpServletRequest req , HttpServletResponse res)throws IOException, ServletException {
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE> Pizza Inventory Consumer </TITLE></HEAD>");
		
		out.println("<BODY><BIG>");
		if (inventory.makePizza()) {
			out.println("your Pizza will be ready in a few Mins ");
		}
		else {
			out.println("We are low on ingreedients.<BR>");
			out.println("Looks like you are gonna strave");
		}
		out.println("</BIG></BODY></HTML>");
	}
}
