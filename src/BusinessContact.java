
public class BusinessContact extends Contact{
	private String company;
	private String linkedIn;
	
	public BusinessContact(String name, String email, String phone, String company, String linkedIn)
			throws InvalidEmailTypeException, InvalidPhoneException {
		super(name, email, phone);
		this.company = company;
		this.linkedIn = linkedIn;
	}


	public void printContact() {
		System.out.print(getName() + "\t\t" + getEmail() + "\t\t" + getPhone() + "\t\tCompany: " + company + "\t\tLinkedIn: " + linkedIn + "\n");
	}


	public String getCompany() {
		return company;
	}


	public void setCompany(String company) {
		this.company = company;
	}


	public String getLinkedIn() {
		return linkedIn;
	}


	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}

}
