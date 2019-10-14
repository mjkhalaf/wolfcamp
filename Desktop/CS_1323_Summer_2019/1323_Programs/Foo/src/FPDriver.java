import java.util.Date;

public class FPDriver {

	public static void main(String[] args) {
		FloatPoint2 fp = new FloatPoint2(3.2, 2.3);
		System.out.println(fp);
		
		Object o =fp;
		System.out.println(o);
		
		Double what = fp.getX();
		what += 2.0;
		
		Date aha = fp.getDate();
		aha.setHours(10);
		aha.setMonth(11);
		
		System.out.println("1" + 2);
	}

}
