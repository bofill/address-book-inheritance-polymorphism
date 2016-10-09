
public class PersonalContact extends Contact{
	private String facebook;
	private String whatsApp;
	
	public PersonalContact(String name, String email, String phone, String facebook, String whatsApp)
			throws InvalidEmailTypeException, InvalidPhoneException {
		super(name, email, phone);
		this.facebook = facebook;
		this.whatsApp = whatsApp;
	}


	public void printContact() {
		System.out.print(getName() + "\t\t" + getEmail() + "\t\t" + getPhone() + "\t\tFacebook: " + facebook + "\t\tWatsApp: " + whatsApp + "\n");
	}


	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}


	public String getWhatsApp() {
		return whatsApp;
	}


	public void setWhatsApp(String whatsApp) {
		this.whatsApp = whatsApp;
	}

	
}
