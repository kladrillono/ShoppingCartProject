import java.util.Scanner;
import java.util.Arrays;

public final class ArrayBag<T> extends Item implements ShoppingCartInterface<T>
{
	private T[] bag;
	private int numberOfEntries;
	private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	//Creates an empty bag whose initial capacity is 25. 
	public ArrayBag()
	{
		this(DEFAULT_CAPACITY);
	}// end default constructor

	//Creates an empty bag with a given initial capacity.
	public ArrayBag(int initialCapacity)
	{
		checkCapacity(initialCapacity);
	  
      // The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] tempBag = (T[])new Object[initialCapacity]; // Unchecked cast
		bag = tempBag;
		numberOfEntries = 0;
		integrityOK = true;
	} // end constructor
   
	//Retrieves all items that are in the shopping cart.
	//Will return a new array of all the items in the shopping cart.
	public T[] toArray()
	{
		checkIntegrity();
		
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];
	
		for (int index = 0; index<numberOfEntries; index++) 
		{
			result[index] = bag[index];
		}
		return result;
	} // end toArray
	
	// Returns true if the array bag is full, or false if not.
	private boolean isArrayFull()
	{
		return numberOfEntries >= bag.length;
	}// end isArrayFull

	//Gets the current number of items in the shopping cart. 
	//Will return an integer.
	@Override
	public int getCurrentNumItems() 
	{
		return numberOfEntries;
	}// end getCurrentNumItems

	//Checks if the shopping cart is empty. 
	//Will return true if the cart is empty or false if it is not empty.
	@Override
	public boolean isEmpty() 
	{
		return numberOfEntries == 0;
	}// end isEmpty
	
	//Adds a new item (newItem) to the shopping cart.
	//Will return true if the addition is successful, or false if unsuccessful.
	@Override
	public boolean addItem(T newItem) {
		
		checkIntegrity();
		
		boolean result = true;
		if (isArrayFull()) {
			result = false;
		}
		else {
			bag[numberOfEntries] = newItem;
			numberOfEntries++;
		}
		return result;
	} // end addItem

	//Removes one unspecified item from the shopping cart, if possible.
    //Will return the name of the item if successful or null if not.     
	@Override
	public T removeItem() 
	{
		checkIntegrity();
		T result = removeItem(numberOfEntries -1);
		return result;
	}// end removeItem
	
	//removes an item at a given index
	private T removeItem(int givenIndex) 
	{
		T result = null;
		
		if (!isEmpty() && (givenIndex >= 0)) 
		{
			result = bag[givenIndex];
			int lastIndex = numberOfEntries - 1;
			bag[givenIndex] = bag[lastIndex];
			bag[lastIndex] = null;
			numberOfEntries--;
		}
		return result;
	}// end removeItem

	//determines where in the array an item is located
	private int getIndexOf(T anItem) 
	{
		int where = -1;
		boolean found = false;
		int index = 0;
		
		while (!found && (index < numberOfEntries)) 
		{
			if (anItem.equals(bag[index])) 
			{
				found = true;
				where = index;
			}// end if
			index++;
		}// end while
		return where;
	}// end getIndexOf
	
	//Removes one instance of a specific item (anItem) from the shopping cart, if possible.
    //Will return true if the removal was successful or false if unsuccessful.
	@Override
	public boolean removeItem(T anItem) 
	{
		checkIntegrity();
		int index = getIndexOf(anItem);
		T result = removeItem(index);
		return anItem.equals(result);
	}// end removeItem

	//Deletes all items from the shopping cart.
	@Override
	public void clearItems() 
	{
		while(!isEmpty())
		removeItem();
	}// end clearItems

	//Counts the number of times a specific item (anItem) occurs in the shopping cart.
	//Will return an integer of the number of times anItem occurs.
	@Override
	public int getNumberOf(T anItem) 
	{	
		checkIntegrity();
		
		int counter = 0;
		
		for (int index = 0; index < numberOfEntries; index++) 
		{
			if (anItem.equals(bag[index])) {
				counter++;
			}
		}
		return counter;
	}// end getNumberOf

	//Checks if the shopping cart contains a specific item (anItem).
	//Will return true if the shopping cart contains anItem, or false if it does not.
	@Override
	public boolean contains(T anItem)
	{
		checkIntegrity();
		
		boolean found = false;
		int index = 0;
		while (!found && (index<numberOfEntries)) {
			if(anItem.equals(bag[index])) {
				found = true;
			}
			index++;
		}
		return found;
	}// end contains

	//Calculates the total price of items in the shopping cart.
	//Will return an integer of the total price.
	@Override
	public int getTotalPrice()
	{
		int totalSum = 0;
		
		for (int item=0; item < numberOfEntries; item++) 
		{			
			totalSum += ((Item) bag[item]).getPrice();
		}
		return totalSum;
	}// end getTotalPrice

	//Allows the user to enter a delivery address.
	//Will return a string of the address after entry.
	@Override
	public String addDeliveryAddress() 
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your Street Address: ");
		String address = scan.nextLine();
		System.out.println("Enter your City, State, Zip Code: ");
		String address2 = scan.nextLine();
		
		String message;
		message = "Delivery Address: "+"\n"+address+"\n"+address2;
		scan.close();
		
		return message;
	}// end addDeliveryAddress
	
	//exception for reaching the bag's capacity
	private void checkCapacity(int capacity) 
	{
		if (capacity > MAX_CAPACITY)
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds " + "allowed maximum of " + MAX_CAPACITY);
	}// end checkCapacity
	
	//exception for checking integrity of the bag
	private void checkIntegrity() 
	{
		if (!integrityOK)
			throw new SecurityException ("ArrayBag object is corrupt.");
	}// end checkIntegrity
	
} // end ArrayBag class