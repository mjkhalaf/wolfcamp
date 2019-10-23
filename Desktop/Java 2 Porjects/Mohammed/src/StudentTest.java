import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	private static final int INTITAL_RATING = 5;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testStudent() {
		Student s;
		try {
			s = new Student();
		
		Integer rating = s.getRating();
		Integer expected = INTITAL_RATING;
		
		assertEquals(expected, rating);
		} catch (NameException e) {
			fail();
		}
	}

	@Test
	public void testCompareTo() throws NameException {
		Student firstStudent = new Student("x", "y", 2);
		Student SecondStudent = new Student("x", "y", 3);
		
		boolean result = false;
		int actual = SecondStudent.compareTo(firstStudent);
		int expected = 1;
		
		if (actual > 0) {
			result = true;
		}
		
		assertTrue(result);
		
		Student tudent = new Student("x", "y", 5);
		result = false;
		expected = 0;
		actual = SecondStudent.compareTo(tudent);
		assertEquals(expected, actual);
	}
	@Test
	public void testGet() throws NameException {
		Integer expected = INTITAL_RATING;
		Integer rating = expected;
		String firstName = "Alex";
		String lastName = "Khalaf";
		Student s = new Student(firstName, lastName, rating);
		Integer actual = s.getRating();
		assertEquals(expected, actual);
	}
}
