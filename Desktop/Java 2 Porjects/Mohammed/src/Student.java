
public class Student extends Person implements Comparable<Student> {
	private String className;
	private Integer rating;
	private static final int INTITAL_RATING = 5;
	
	public Student() throws NameException {
		super();
		rating = INTITAL_RATING;
	}
	
	public Student(String firstName, String lastName, Integer rating) throws NameException {
		// TODO Auto-generated constructor stub
		super(firstName, lastName);
		this.rating = rating;
	}

	@Override
	public int compareTo(Student o) {
		return rating - o.getRating();
		
	}

	public Integer getRating() {
		// TODO Auto-generated method stub
		return new Integer(rating);
	}

}
