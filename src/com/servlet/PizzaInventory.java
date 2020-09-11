package com.servlet;

public class PizzaInventory {

	// process the constructor , so no other class can not call it
	private PizzaInventory() {}
	
	// create only the instance , save it to a private static variable
	private static PizzaInventory instance = new  PizzaInventory();
	
	// make the static instance publicly available
	public static PizzaInventory getInstance() {return instance;}
	
	// how many service of each item do we have
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
	
}
