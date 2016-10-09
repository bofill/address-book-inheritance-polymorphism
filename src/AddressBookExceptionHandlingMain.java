
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBookExceptionHandlingMain {
	static Scanner scan = new Scanner(System.in);
	static ArrayList<Contact> Contacts = new ArrayList<Contact>();

	public static void main(String[] args){
		boolean loop = true;

		do {
			printMenu();
			int choice = scan.nextInt();
			scan.nextLine();

			switch (choice){
			case 1: 
				getUserContact();
				break;
			case 2: 
				System.out.println("Please enter contact's number on list you want to edit: ");
				editContact(getArrayListIndex());
				break;
			case 3: 
				System.out.println("Please enter contact's number on list you want to delete: ");				
				deleteContact(getArrayListIndex());
				break;
			case 4: 
				printContactsList(Contacts);
				break;
			case 5: 
				loop = false;
				break;
			}
		}while (loop == true);
		scan.close();
	}

	public static void getUserContact(){
		PersonalContact newPersonalContact = null;
		BusinessContact newBusinessContact = null;
		String newName, newEmail, newPhone, newFacebook, newWhatsApp, newCompany, newLinkedIn;
		newName = newEmail = newPhone = null; 
		//why do I have to initialize name, email and phone only?
		boolean isValid = false;
		while(!isValid){

			System.out.println("Which type of Contact do you want to ADD?");
			System.out.println("1) for Personal, 2) for Business");
			int choice = scan.nextInt();

			if(choice == 1 || choice == 2){
				scan.nextLine();
				System.out.print("Enter Contact name: \n");
				newName = scan.nextLine();
				System.out.print("Enter Contact email: \n");
				newEmail = scan.nextLine();
				System.out.print("Enter Contact phone: \n");
				newPhone = scan.nextLine();
			}
			if (choice == 1){
				System.out.print("Enter Contact Facebook: \n");
				newFacebook = scan.nextLine();
				System.out.print("Enter Contact WhatsUp: \n");
				newWhatsApp = scan.nextLine();
				try {
					newPersonalContact = new PersonalContact(newName, newEmail, newPhone, newFacebook, newWhatsApp);
					isValid = true;
				} catch (InvalidEmailTypeException e) {
					System.out.println(e.getMessage());
					scan.nextLine();
					isValid = false;
				} catch (InvalidPhoneException e) {
					System.out.println(e.getMessage());
					scan.nextLine();
					isValid = false;
				}
				Contacts.add(newPersonalContact);
			}
			if (choice == 2){
				System.out.print("Enter Contact Company: \n");
				newCompany = scan.nextLine();
				System.out.print("Enter Contact LinkedIn: \n");
				newLinkedIn = scan.nextLine();
				try {
					newBusinessContact = new BusinessContact(newName, newEmail, newPhone, newCompany, newLinkedIn);
					isValid = true;
				} catch (InvalidEmailTypeException e) {
					System.out.println(e.getMessage());
					scan.nextLine();
					isValid = false;
				} catch (InvalidPhoneException e) {
					System.out.println(e.getMessage());
					scan.nextLine();
					isValid = false;
				}
				Contacts.add(newBusinessContact);
			}
		}
	}

	public static void addContact(Contact newContact){
		Contacts.add(newContact);
	}

	public static void editContact(int index){		
		System.out.println("Please chose what would you like to edit inside " + Contacts.get(index).getName());
		if(Contacts.get(index) instanceof PersonalContact){
			System.out.println("1) for Name, 2) for Email, 3) for Phone Number, "
					+ "4) for Facebook, 5) for WhatsApp");
		}
		if(Contacts.get(index) instanceof BusinessContact){
			System.out.println("1) for Name, 2) for Email, 3) for Phone Number, "
					+ "4) for Company, 5) for LinkedIn");	
		}
		int choice = scan.nextInt();

		if(choice == 1){
			scan.nextLine();
			System.out.print("please enter new Name: \n");
			String newName = scan.nextLine();
			Contacts.get(index).setName(newName);
		}
		else if(choice == 2){
			boolean isValid = false;
			while (!isValid){
				scan.nextLine();
				System.out.print("please enter new Email: \n");
				String newEmail = scan.nextLine();
				try {
					Contacts.get(index).setEmail(newEmail);
					isValid = true;
				} catch (InvalidEmailTypeException e) {
					System.out.print(e.getMessage());
					isValid = false;
				}
			}
		}
		else if(choice == 3){
			boolean isValid = false;
			while (!isValid){
				scan.nextLine();
				System.out.print("please enter new Phone Number: \n");
				String newPhone = scan.nextLine();
				try {
					Contacts.get(index).setPhone(newPhone);
					isValid = true;
				} catch (InvalidPhoneException e) {
					System.out.println(e.getMessage());
					isValid = false;
				}
			}
		}
		else if (choice == 4 && Contacts.get(index) instanceof PersonalContact){
			scan.nextLine();
			System.out.print("please enter new Facebook: \n");
			String newFacebook = scan.nextLine();
			((PersonalContact)Contacts.get(index)).setFacebook(newFacebook);
		}
		else if (choice == 4 && Contacts.get(index) instanceof BusinessContact){
			scan.nextLine();
			System.out.print("please enter new Company: \n");
			String newCompany = scan.nextLine();
			((BusinessContact)Contacts.get(index)).setCompany(newCompany);
		}
		else if (choice == 5 && Contacts.get(index) instanceof PersonalContact){
			scan.nextLine();
			System.out.print("please enter new WhatsApp: \n");
			String newWhatsApp = scan.nextLine();
			((PersonalContact) Contacts.get(index)).setWhatsApp(newWhatsApp);
		}
		else {
			scan.nextLine();
			System.out.print("please enter new LinkedIn: \n");
			String newLinkedIn = scan.nextLine();
			((BusinessContact)Contacts.get(index)).setLinkedIn(newLinkedIn);
		}
	}

	public static void deleteContact(int index){
		Contacts.remove(index);
	}

	public static void printContactsList(ArrayList<Contact> Contacts){
		System.out.println("CONTACTS LIST");
		System.out.println("Name\t\tEmail\t\tPhone Number");
		for (Contact c: Contacts) {
			if (c instanceof PersonalContact){
				((PersonalContact)c).printContact();
			}
			if (c instanceof BusinessContact){
				((BusinessContact)c).printContact();
			}
		}
	}

	public static int getArrayListIndex(){
		int index = scan.nextInt();
		index -= 1; 
		return index;
	}

	public static void printMenu(){
		System.out.println("CONTACT BOOK");
		System.out.print("Please chose from menu\n"
				+ "1 - ADD a new Contact\n"
				+ "2 - EDIT existing Contact\n"
				+ "3 - DELETE existing Contact\n"
				+ "4 - SHOW all Contacts\n"
				+ "5 - QUIT\n");
	}
}
