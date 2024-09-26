package Resto_Management;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Menu{
	String MenuID;
	String Name;
	double Price;
	boolean availability;
	
	public Menu (String id, String name, double price, boolean avl) {
		this.MenuID = id;
		this.Name = name;
		this.Price = price;
		this.availability = avl;
	}
	
	public String getMenuID() {
		return MenuID;
	}
	public void setMenuID(String menuID) {
		MenuID = menuID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
}


class Owner{
	String Name;
	int PhoneNumber;
	String Address;
	
	public Owner (String Name, int phone, String Address) {
		this.Name = Name;
		this.PhoneNumber = phone;
		this.Address = Address;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
}

class Item{
	String ItemID;
	String Name;
	int Quantity;
	double TotalCost;
	
	public Item (String ID, String name, int quantity, double total) {
		this.ItemID = ID;
		this.Name = name;
		this.Quantity = quantity;
		this.TotalCost = total;
	}

	public String getItemID() {
		return ItemID;
	}
	public void setItemID(String itemID) {
		ItemID = itemID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public double getTotalCost() {
		return TotalCost;
	}
	public void setTotalCost(float totalCost) {
		TotalCost = totalCost;
	}
}

class Order{
	String CustomerName;
	String OrderID;
	List<Item> order = new ArrayList<Item>();
	double totalamount;
	
	public Order (String name, String id, List<Item> order, double total) {
		this.CustomerName = name;
		this.order = order;
		this.OrderID = id;
		this.totalamount = total;
	}
	
	public String getCustomerName() {
		return CustomerName;
	}
	
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getOrderID() {
		return OrderID;
	}
	public void setOrderID(String orderID) {
		OrderID = orderID;
	}
	public List<Item> getOrder() {
		return order;
	}
	public void setOrder(List<Item> order) {
		this.order = order;
	}
	public double getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(double totalamount) {
		this.totalamount = totalamount;
	}
	
}

class Online extends Order{
	String Address;
	int PhoneNumber;
	Online(String name, String id, List<Item> order, double total, String Address, int Phone){
		super(name, id, order, total);
		this.Address = Address;
		this.PhoneNumber = Phone;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
}

class Onsite extends Order{
	int Table;
	Onsite(String name, String id, List<Item> order, double total, int table){
		super(name, id, order, total);
		this.Table = table;
	}
	public int getTable() {
		return Table;
	}
	public void setTable(int table) {
		Table = table;
	}
	
	
}

class management{
	ArrayList<Online> online;
	ArrayList<Onsite> onsite;
	ArrayList<Menu> menu;
	
	public management() {
		online = new ArrayList<>();
		onsite = new ArrayList<>();
		menu = new ArrayList<>();
	}

	public ArrayList<Online> getOnline() {
		return online;
	}

	public void setOnline(Online onl) {
		online.add(onl);
	}

	public ArrayList<Onsite> getOnsite() {
		return onsite;
	}

	public void setOnsite(Onsite ost) {
		onsite.add(ost);
	}
	
	public ArrayList<Menu> getMenu() {
		return menu;
	}

	public void setMenu(Menu mnu) {
		menu.add(mnu);
	}
}

public class Manage {
	public static void main(String[] args) {
		management mng = new management();
		mng.setMenu(new Menu("F1", "Grilled Dragon Fish", 10.20, true));
		mng.setMenu(new Menu("F2", "Grilled Dragon", 12.1, true));
		mng.setMenu(new Menu("F3", "Grilled", 19.2, true));
		Scanner sc = new Scanner(System.in);
		int Input;
		int orderid = 1;
		int menuid = 4;
		
		do {
			System.out.println("1. Owner");
			System.out.println("2. Customer");
			System.out.println("3. Exit");
			System.out.print("Choice: ");
			Input = sc.nextInt(); sc.nextLine();
			System.out.println("");
			int choice;
			switch(Input) {
			case 1:
					
				do {
					System.out.println("");
					System.out.println("1. Create Menu");
					System.out.println("2. Read Menu");
					System.out.println("3. Read Order");
					System.out.println("4. Update Menu");
					System.out.println("5. Delete Menu");
					System.out.println("6. Return");
					System.out.print("Choice: ");
					choice = sc.nextInt(); sc.nextLine();
					
					switch(choice) {
					case 1:
						System.out.println("");
						Createmenu(mng, sc, menuid);
						menuid++;
						break;
					case 2:
						System.out.println("");
						viewmenu(mng);
						break;
					case 3:
						System.out.println("");
						vieworder(mng);
						break;
					case 4:
						System.out.println("");
						Editmenu(mng, sc);
						break;
					case 5:
						System.out.println("");
						Deletemenu(mng, sc);
						break;
					}
					
				}while(choice != 6);
				
				break;
				
			case 2:
				
				do {
					System.out.println("");
					System.out.println("1. Create Order");
					System.out.println("2. Read Menu");
					System.out.println("3. View Your Order");
					System.out.println("4. Exit");
					System.out.print("Choice: ");
					choice = sc.nextInt(); sc.nextLine();	
					
					switch(choice) {
					case 1:
						do {
							System.out.println("");
							System.out.println("1. Onsite");
							System.out.println("2. Online");
							System.out.println("3. Done");
							System.out.print("Choice: ");
							choice = sc.nextInt(); sc.nextLine();	
							
							switch(choice) {
							case 1:
								System.out.println("");
								Orderonsite(mng, sc, orderid);
								orderid++;
								break;
							case 2:
								System.out.println("");
								Orderoline(mng, sc, orderid);
								orderid++;
								break;
							}
						}while(choice != 3);
						
						break;
						
					case 2:
						viewmenu(mng);
						break;
						
					case 3:
						System.out.println("");
						String ID;
						boolean status = vieworderlite(mng);
							if(status == false) {
								break;
							}else {
								do {
							
								System.out.print("Input your order ID: ");
								ID = sc.nextLine();
								}while(!ID.substring(0,2).equals("OS") && !ID.substring(0,2).equals("OL"));
							
								viewcurorder(mng, ID);
							}
						
						break;
				    }
					
				    
				}while(choice != 4);
				
			}
			
		}while(Input != 3);
		
	}
	
	private static void Createmenu(management mng, Scanner sc, int menuid) {
		String Name;
		double price;
		boolean availability;
		
		System.out.print("Input Menu name : ");
		Name = sc.nextLine();
		
		System.out.print("Input Menu Price : ");
		price = sc.nextDouble(); sc.nextLine();
		
		System.out.print("Input Menu Availability (True | False) : ");
		availability = sc.nextBoolean();
		
		Menu menu = new Menu("F"+menuid, Name, price, availability);
		mng.getMenu().add(menu);
		System.out.println("Added Sucessfully");
		System.out.println("");
	}
	
	private static void Editmenu(management mng, Scanner sc) {
		viewmenu(mng);	
		String ID;
		int input;
		boolean flag = false;
		
		do {
		System.out.println("Input menu ID: ");
		ID = sc.nextLine();
		
		for (Menu menu : mng.getMenu()) {
            if (menu.getMenuID().equals(ID)) {
            	flag = true;
            	do {
            		System.out.println("");
            		System.out.println("1. MenuID: " + menu.getMenuID());
	            	System.out.println("2. Menu Name: " + menu.getName());
	            	System.out.println("3. Price: " + menu.getPrice());
	            	System.out.println("4. Menu Availability: " + menu.isAvailability());
	            	System.out.println("5. Done");
	            	System.out.println("");
	            	
	            	System.out.println("Which part of the menu you want to edit: ");
	            	input = sc.nextInt(); sc.nextLine();
	            	
	            	switch(input) {
	            	case 1:
	            		int newID;
	            		System.out.print("Input new menu ID: F");
	            		newID = sc.nextInt(); sc.nextLine();
	            		menu.setMenuID("F" + newID);
	            		System.out.println("Successfully Changed");
	            		break;
	            	case 2:
	            		String newname;
	            		System.out.print("Input new menu Name: ");
	            		newname = sc.nextLine();
	            		menu.setMenuID(newname);
	            		System.out.println("Successfully Changed");
	            		break;
	            	case 3:
	            		double newprice;
	            		System.out.print("Input new menu price: ");
	            		newprice = sc.nextDouble(); sc.nextLine();
	            		menu.setPrice(newprice);
	            		System.out.println("Successfully Changed");
	            		break;
	            	case 4:
	            		boolean newstatus;
	            		System.out.print("Input new menu Availability (True | False): ");
	            		newstatus = sc.nextBoolean(); sc.nextLine();
	            		menu.setAvailability(newstatus);
	            		System.out.println("Successfully Changed");
	            		break;
	            	
	            	case 5:
	            		return;
	            	}
	            	
	            	break;
            	}while(input != 5);
            	
            }
		}
		}while(flag == false);
		
	}
	
	private static void Deletemenu(management mng, Scanner sc) {
		viewmenu(mng);	
		String ID;
		String input;
		boolean Flag = false;
		
		do {
		System.out.print("Input menu ID: ");
		ID = sc.nextLine();
		
		Iterator<Menu> itr = mng.getMenu().iterator();
		while(itr.hasNext()) {
			Menu item = itr.next();
			
			if(item.getMenuID().equals(ID)) {
				Flag = true;
				do {
	            	System.out.println("Are you sure you want to delete this menu?");
	            	System.out.print("(Yes | No) : ");
	            	input = sc.nextLine();
	            	}while(!input.equals("Yes") && !input.equals("No"));
	            	
	            	if(input.equals("Yes")) {
	            		itr.remove();
	            		System.out.println("Successfully Deleted");
	            	}else if(input.equals("No")) {
	            		System.out.println("deletion Canceled");
	            		return;
	            	}
				
				return;
			}
		}
		
		}while(Flag == false);
	}
	
	private static void Orderonsite(management mng, Scanner sc, int orderid) {
		int choice = 0;
		String name;
		int table;
		double total = 0;
		List<Item> items = new ArrayList<>();
		
		System.out.print("Input your name: ");
		name = sc.nextLine();
		
		System.out.print("Input your table: ");
		table = sc.nextInt(); sc.nextLine();
		
		do {
			System.out.println("");
			viewmenu(mng);
			System.out.println("");
			System.out.println("1. Add menu");
			System.out.println("2. Done");
			System.out.print("choose: ");
			choice = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			if(choice == 1) {
				items.add(createitem(mng, sc));
				System.out.println("");
				System.out.println("Added to list");
				System.out.println("");
			}
			System.out.println("");
		}while(choice != 2);
		
		total = calculateTotalAmount(items);
		
		Onsite os = new Onsite(name, "OS"+orderid, items, total, table);
		mng.getOnsite().add(os);
		System.out.println("Added Sucessfully");
		System.out.println("");
	}
	
	private static void Orderoline(management mng, Scanner sc, int orderid) {
		int choice = 0;
		String name;
		String Address;
		int phonenumber;
		double total = 0;
		List<Item> items = new ArrayList<>();
		
		System.out.print("Input your name: ");
		name = sc.nextLine();
		
		System.out.print("Input your Address: ");
		Address = sc.nextLine();
		
		System.out.print("Input your phonenumber: ");
		phonenumber = sc.nextInt(); sc.nextLine();
		
		do {
			System.out.println("");
			viewmenu(mng);
			System.out.println("");
			System.out.println("1. Add menu");
			System.out.println("2. Done");
			System.out.print("choose: ");
			choice = sc.nextInt(); sc.nextLine();
			System.out.println("");
			
			if(choice == 1) {
				items.add(createitem(mng, sc));
				System.out.println("");
				System.out.println("Added to list");
				System.out.println("");
			}
			System.out.println("");
		}while(choice != 2);
		
		total = calculateTotalAmount(items);
		
		Online on = new Online(name, "OL"+orderid, items, total, Address, phonenumber);
		mng.getOnline().add(on);
		System.out.println("Added Sucessfully");
		System.out.println("");
	}
	
	public static Item createitem(management mng, Scanner sc) {
		String ID;
		int quantity;
		
		do {
		System.out.print("Input Menu ID: ");
		ID = sc.nextLine();
		
			if(!isMenuIDExists(ID, mng)) {
				System.out.println("Wrong menu id");
			}else {
				if(isMenuavailable(ID, mng) == true) {
					break;
				}else {
					System.out.println("Menu is not available please pick another item.");
					System.out.println("");
				}
				
			}
		
		}while(true);
		
		System.out.print("Input quantity of order: ");
		quantity = sc.nextInt(); sc.nextLine();
		
		Menu menu = getmenubyid(ID, mng);
		return new Item(menu.getMenuID(), menu.getName(), quantity, menu.getPrice()*quantity);
	}
	
	public static Menu getmenubyid(String ID, management mng) {
		
		for (Menu menu : mng.getMenu()) {
            if (menu.getMenuID().equals(ID)) {
                return menu;
            }
        }
		return null;
	}
	
	private static void viewmenu(management mng) {
		System.out.println("Menu :");
        System.out.println("=========================================================================");
        System.out.printf("| %-5s | %-30s | %-10s | %-15s |\n", "ID", "Name", "Price", "Availability");
        System.out.println("=========================================================================");

     
		for(Menu mnu : mng.getMenu()) {
			System.out.printf("| %-5s | %-30s | %-10.2f | %-15s |\n", mnu.getMenuID(), mnu.getName(), mnu.getPrice(),
                    mnu.isAvailability() ? "Available" : "Not Available");
		}
		System.out.println("=========================================================================");
		System.out.println();
	}
	
	private static boolean isMenuIDExists(String ID, management mng) {
        for (Menu menu : mng.getMenu()) {
            if (menu.getMenuID().equals(ID)) {
                return true;
            }
        }
        return false;
    }
	
	private static boolean isMenuavailable(String ID, management mng) {
        for (Menu menu : mng.getMenu()) {
            if (menu.getMenuID().equals(ID)) {
            	if(menu.isAvailability() == true) {
            		return true;
            	}else {
            		return false;
            	}
            }
        }
        return false;
    }
	
	public static double calculateTotalAmount(List<Item> items) {
        double total = 0.0;
        for (Item item : items) {
            total += item.getTotalCost();
        }
        return total;
    }
	
	private static void vieworder(management mng) {
		
		if(mng.getOnline().isEmpty() && mng.getOnsite().isEmpty()) {
			System.out.println("Order list is empty");
			return;
		}else {
			int number = 1;
			if(mng.getOnsite().isEmpty()) {
				
			}else {
				
				System.out.println("Onsite order");
				for(Onsite os : mng.getOnsite()) {
					System.out.println(number + ".");
					System.out.println("Customer Name = " + os.getCustomerName());
					System.out.println("Order ID  = " + os.getOrderID());
					
					int itemnum = 1;
					System.out.println("");
					System.out.println("Ordered Menu:");
					System.out.println("");
					for(Item item : os.getOrder()) {
						System.out.println(itemnum + ".");
						System.out.println("Menu ID = " + item.getItemID());
						System.out.println("Menu name = " + item.getName());
						System.out.println("Menu Quantity = " + item.getQuantity());
						System.out.println("Menu price = " + item.getTotalCost()/item.getQuantity());
						itemnum++;
						System.out.println("");
					}
					System.out.println("Table = " + os.getTable());
					System.out.println("Total price = " + os.getTotalamount());
					
					System.out.println("");
					
				}
			}
			
			if(mng.getOnsite().isEmpty()) {
				
			}else {
				number = 1;
				System.out.println("Online order");
				for(Online on : mng.getOnline()) {
					System.out.println("");
					System.out.println(number + ".");
					System.out.println("Customer Name = " + on.getCustomerName());
					System.out.println("Order ID  = " + on.getOrderID());
					
					int itemnum = 1;
					System.out.println("");
					System.out.println("Ordered Menu:");
					System.out.println("");
					for(Item item : on.getOrder()) {
						System.out.println(itemnum + ".");
						System.out.println("Menu ID = " + item.getItemID());
						System.out.println("Menu name = " + item.getName());
						System.out.println("Menu Quantity = " + item.getQuantity());
						System.out.println("Menu price = " + item.getTotalCost()/item.getQuantity());
						itemnum++;
						System.out.println("");
					}
					System.out.println("Customer Address = " + on.getAddress());
					System.out.println("Customer Phone Number = " + on.getPhoneNumber());
					System.out.println("Total price = " + on.getTotalamount());
					
					System.out.println("");
					number++;
				}
			}
		}
	}
	
	private static void viewcurorder(management mng, String ID) {
		
		if(ID.substring(0,2).equals("OS")) {
			for (Onsite os : mng.getOnsite()) {
		           if (os.getOrderID().equals(ID)) {
		        	   System.out.println("");
					System.out.println("Customer Name = " + os.getCustomerName());
					System.out.println("Order ID  = " + os.getOrderID());
					
					int itemnum = 1;
					System.out.println("");
					System.out.println("Ordered Menu:");
					System.out.println("");
					for(Item item : os.getOrder()) {
						System.out.println(itemnum + ".");
						System.out.println("Menu ID = " + item.getItemID());
						System.out.println("Menu name = " + item.getName());
						System.out.println("Menu Quantity = " + item.getQuantity());
						System.out.println("Menu price = " + item.getTotalCost()/item.getQuantity());
						itemnum++;
						System.out.println("");
					}
					System.out.println("Table = " + os.getTable());
					System.out.println("Total price = " + os.getTotalamount());
					
					System.out.println("");
				}
			}
		}else if(ID.substring(0,2).equals("OL")){
			for (Online on : mng.getOnline()) {
		           if (on.getOrderID().equals(ID)) {
		           	System.out.println("Customer Name = " + on.getCustomerName());
		           	System.out.println("Order ID  = " + on.getOrderID());
				
					int itemnum = 1;
					for(Item item : on.getOrder()) {
						System.out.println(itemnum);
						System.out.println("Menu ID = " + item.getItemID());
						System.out.println("Menu name = " + item.getName());
						System.out.println("Menu Quantity = " + item.getQuantity());
						System.out.println("Menu price = " + item.getTotalCost()/item.getQuantity());
						itemnum++;
						System.out.println("");
					}
					System.out.println("Customer Address = " + on.getAddress());
					System.out.println("Customer Phone Number = " + on.getPhoneNumber());
					System.out.println("Total price = " + on.getTotalamount());
					
					System.out.println("");
		           }
			}
		}
	}
	
	public static boolean vieworderlite(management mng) {
		if(mng.getOnline().isEmpty() && mng.getOnsite().isEmpty()) {
			System.out.println("Order list is empty");
			System.out.println("");
			return false;
		}else {
			int number = 1;
			if(mng.getOnsite().isEmpty()) {
				
			}else {
				System.out.println("");
				System.out.println("Onsite order");
				System.out.println("");
				for(Onsite os : mng.getOnsite()) {
					System.out.println(number + ".");
					System.out.println("Order ID  = " + os.getOrderID());
					System.out.println("Customer Name = " + os.getCustomerName());
					System.out.println("");
					number++;
				}
			}
			
			if(mng.getOnline().isEmpty()) {
				
			}else {
				number = 1;
				System.out.println("");
				System.out.println("Online order");
				System.out.println("");
				for(Online on : mng.getOnline()) {
					System.out.println(number + ".");
					
					System.out.println("Order ID  = " + on.getOrderID());
					System.out.println("Customer Name = " + on.getCustomerName());
					System.out.println("");
					number++;
				}
			}
		}
		return true;
	}
}