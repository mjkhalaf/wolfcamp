
public class Person extends NameHolder {
	
	private String lastName;
	
	public Person() throws NameException {
		String temp1 = "Bo";
		String temp2 = "Smith";
		lastName = temp1;
		super.setFirstName(temp2);
	}
	public Person(String firstName, String lastName) throws NameException
	{
		this.lastName = lastName;
		super.setFirstName(firstName);
		
	}
	@Override
	public String describeSelf() {
		// TODO Auto-generated method stub
		String description  = "First Name: " + getFristName() + " Last Name: " + lastName;
		return description;
		
	}
	
	@Override
	protected String getFristName() {
		// TODO Auto-generated method stub
		return this.firstName;
	}

}
