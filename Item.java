import java.util.ArrayList;

public class Item
{
	private String description;
	private int price;
	private boolean stockStatus;
   
	//creates an empty Item object
   	public Item() 
   	{
   		description = "";
   		price = 0;
   		stockStatus = true;
   	}// end empty-argument constructor
   	
   	//creates an Item object with set description, price, and status
	public Item(String itemDescription, int itemPrice, boolean itemStatus) 
	{
      description = itemDescription;
      price = itemPrice;
      stockStatus = itemStatus;
	} // end constructor
	
	//returns the description of the Item
	public String getDescription() 
	{
      return description;
	} // end getDescription
	
	//returns the price of the Item
	public int getPrice() 
	{
      return price;
	} // end getPrice
	
	// getStatus() will return true if the item is in stock or false if it is out of stock
	public boolean getStatus()
	{
		return stockStatus;
	} // end getStatus 

	//displays the Item and Item information
	@Override
	public String toString() 
	{
		return "Item "+"\n"+"Description: " + description +"\n" +"Price: "+"$" + price +"\n" + "In Stock? " + stockStatus;
	} // end toString
	
} // end Item class

