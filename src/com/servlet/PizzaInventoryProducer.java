package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaInventoryProducer extends HttpServlet {
	
	// get (and keep) a reference to the shared Pizza Inventory
	
	PizzaInventory inventory =  PizzaInventory.getInstance();
	
	public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException , ServletException{
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<HTML>");
		out.println("<HEAD><TITLE> Pizza Inventory Producer </TITLE></HEAD>");
		
		// produce random amount of each item
		
		Random random = new Random();
		
		int cheese = Math.abs(random.nextInt()%10);
		int wheatflour = Math.abs(random.nextInt()%10);
		int bean = Math.abs(random.nextInt()%10);
		int capsicum = Math.abs(random.nextInt()%10);
		// add the item  sto the inventory
		
		inventory.addcheese(cheese);
		inventory.addwheatflour(wheatflour);
		inventory.addBeans(bean);
		inventory.addcapiscum(capsicum);
		
		// print the product result 
		out.println("<BODY>");
		out.println("<H1> Added ingredients : </H1>");
		out.println("<PRE>");
		out.println("Cheese :"+cheese);
		out.println("wheatflour :"+wheatflour);
		out.println("beans :"+bean);
		out.println("capsicum :"+capsicum);
		out.println("</PRE>");
		out.println("</BODY></HTML>");
		
	}
}
