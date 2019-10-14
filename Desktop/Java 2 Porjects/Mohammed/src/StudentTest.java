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
	public void testCompareTo() {
		fail("Not yet implemented");
	}

}
