import java.util.Arrays;

public class ShoppingCartApplication {

	public static void main(String[] args) {
		
		ArrayBag<Item> newBag = new ArrayBag<Item>(10);
		
		//create items and add them to newBag
		Item oneItem = new Item("Milk", 3, true);
		System.out.println(newBag.addItem(oneItem));
		
		Item twoItem = new Item("Bread", 4, true);
		newBag.addItem(twoItem);
		
		Item threeItem = new Item("Rocky Road Ice Cream", 6, true);
		newBag.addItem(threeItem);
		
		Item fourItem = new Item("Coffee creamer", 6, true);
		newBag.addItem(fourItem);
		
		Item fiveItem = new Item("Peanut Butter", 5, true);
		newBag.addItem(fiveItem);
		newBag.addItem(fiveItem);
		
		//displays items in newBag
		System.out.println("The bag contains the following items: ");
		Object[] bagArray = newBag.toArray();
		for (int index=0; index < bagArray.length; index++)
		{
			System.out.println(bagArray[index] + " ");
		}
		
		System.out.println("Current cart total: $" + newBag.getTotalPrice());
		
		
		//test code for counting how many items are in the bag
		System.out.println("How many items are in the cart?");
		System.out.println(newBag.getCurrentNumItems());
		
		//test code that counts the number of fiveItem
		System.out.println("How many times is peanut butter in the cart?");
		System.out.println(newBag.getNumberOf(fiveItem));
		
		//test code that checks if bag contains object fourItem
		System.out.println("Does the bag contain coffee creamer?");
		System.out.println(newBag.contains(fourItem));
		
		//test code for removing a specific item
		System.out.println("Remove oneItem (milk).");
		System.out.println(newBag.removeItem(oneItem));
		
		//test code for removing a non-specific item
		System.out.println("Remove an item.");
		newBag.removeItem();
		
		System.out.println("How many items are in the cart now?");
		System.out.println(newBag.getCurrentNumItems());
		
		//display bag
		System.out.println("The bag contains the following items: ");
		bagArray = newBag.toArray();
		for (int index=0; index < bagArray.length; index++)
		{
			System.out.println(bagArray[index] + " ");
		}
		
		//test code for isEmpty before and after clearing the bag
		System.out.println("Is the bag empty?");
		System.out.println(newBag.isEmpty());
		newBag.clearItems();
		
		System.out.println("Is the bag empty now?");
		System.out.println(newBag.isEmpty());
		
		//test code for addDeliveryAddress
		System.out.println(newBag.addDeliveryAddress());

		
	}// end main

}// end class
