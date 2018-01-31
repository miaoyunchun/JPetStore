import org.junit.Test;

import com.clps.demo.util.DoubleFormat;
import com.clps.demo.util.EncryptUtil;

public class FormatTest {
	@Test
	public void testFormat() {
		
		double pi=3.1415927;
		pi=DoubleFormat.parseDouble(pi);
		System.out.println(pi);
		System.out.println("ֵΪ: "+DoubleFormat.parseDouble(pi));
	}

}
