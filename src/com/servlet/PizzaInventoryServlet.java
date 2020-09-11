package com.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PizzaInventoryServlet extends HttpServlet{
	
	// how many serving of each item we have
private int cheese = 0;
	
	private int wheatflour = 0;
	
	private int beans =0;
	
	private int capiscum = 0;
	
	// Add to the inventory
	
		public void addcheese(int added) {
			cheese += added;
		}
		public void addwheatflour(int added) {
			wheatflour += added;
		}
		public void addBeans(int added) {
			beans += added;
		}
		public void addcapiscum(int added) {
			capiscum += added;
		}
		
		// called when it is time to make pizza
		// return true if there are enough ingredients to make the pizza
		// false if is not, Decrements the ingredients count when there are enough
		
		synchronized public boolean makePizza() {
			// Pizza require on service of each pizza
			
			if (cheese > 0 && wheatflour >0 && beans >0 && capiscum > 0) {
				cheese --;
				wheatflour--;
				beans--;
				capiscum--;
				
				return true;		// make the pizza
			}else {
				return false;		// could not make the pizza
			}
		}
		
		// Display the current inventory count 
		
		public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException , SecurityException{
			
			res.setContentType("text/ html");
			PrintWriter out = res.getWriter();
			
			out.println("<HTML><HEAD><TITLE> Current Inderedients </TITLE></HEAD>");
			out.println("<BODY>");
			out.println("<TABLE BORDER = >");
			out.println("<TR><TH COLSPAN =2> Current indegredients : </TH></TR>");
			out.println("<TR><TD> Cheese : </TD> <TD>" + cheese + "</TD></TR>");
			out.println("<TR><TD> capiscum : </TD> <TD>" + capiscum + "</TD></TR>");
			out.println("<TR><TD> wheatflour : </TD> <TD>" + wheatflour + "</TD></TR>");
			out.println("<TR><TD> beans : </TD> <TD>" + beans + "</TD></TR>");
			out.println("</TABLE>");
			out.println("</BODY></HTML>");
			
		}
		
		// load the stored inventory count
		
		public void init(ServletConfig config) throws ServletException {
			super.init(config);
			loadState();
		}
		
		public void loadState() {
			
			// Try to load the counts
			
			FileInputStream file = null;
		
			try {
				
				file = new FileInputStream("PizzaInventoryServlet.state");
				DataInputStream in =  new DataInputStream(file);
				cheese = in.readInt();
				wheatflour = in.readInt();
				beans = in.readInt();
				capiscum = in.readInt();
				file.close();
				return;
			}
			catch (IOException e) {
				// TODO: handle exception
				// problem during read
			}
			finally {
				try {
					if (file != null) {
						file.close();
					}
					
				} catch (Exception ignored) {
					// TODO: handle exception
				}
			}
		}
		
		public void destroy() {
			saveState();
		}
		public void saveState() {
			// try to save the counts 
			FileOutputStream file = null;
			try {
				file = new FileOutputStream("PizzaInventoryServlet.state");
				DataOutputStream prnWriter = new DataOutputStream(file);
				prnWriter.writeInt(cheese);
				prnWriter.writeInt(wheatflour);
				prnWriter.writeInt(beans);
				prnWriter.writeInt(capiscum);
			}
			catch (IOException ignored) {
				// TODO: handle exception
			}
			finally {
				try {
					if (file != null) {
						file.close();
					}
				} catch (IOException ignored) {
					// TODO: handle exception
				}
			}
		}
}
