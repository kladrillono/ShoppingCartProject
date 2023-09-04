public interface ShoppingCartInterface<T>
{
	
	//Gets the current number of items in the shopping cart. 
	//Will return an integer.
	public int getCurrentNumItems();
	
	//Checks if the shopping cart is empty. 
	//Will return true if the cart is empty or false if it is not empty.
	public boolean isEmpty();
	
	//Adds a new item (newItem) to the shopping cart.
	//Will return true if the addition is successful, or false if unsuccessful.
	public boolean addItem(T newItem);

	//Removes one unspecified item from the shopping cart, if possible.
    //Will return the name of the item if successful or null if not.          
	public T removeItem();
   
	//Removes one instance of a specific item (anItem) from the shopping cart, if possible.
    //Will return true if the removal was successful or false if unsuccessful.
    public boolean removeItem(T anItem);
	
	//Deletes all items from the shopping cart.
	public void clearItems();
	
	//Counts the number of times a specific item (anItem) occurs in the shopping cart.
	//Will return an integer of the number of times anItem occurs.
	public int getNumberOf(T anItem);
	
	//Checks if the shopping cart contains a specific item (anItem).
	//Will return true if the shopping cart contains anItem, or false if it does not.
	public boolean contains(T anItem);
	
	//Calculates the total price of items in the shopping cart.
	//Will return an integer of the total price.
	public int getTotalPrice();
	
	//Allows the user to enter a delivery address.
	//Will return a string of the address after entry.
	public String addDeliveryAddress();
   
	//Retrieves all items that are in the shopping cart.
	//Will return a new array of all the items in the shopping cart.
	public T[] toArray();

	
} // end ShoppingCartInterface
