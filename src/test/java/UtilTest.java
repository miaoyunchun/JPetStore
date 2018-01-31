import java.util.List;

import org.junit.Test;

import com.clps.demo.dao.impl.CategoryDao;
import com.clps.demo.domain.Item;
import com.clps.demo.util.EncryptUtil;

public class UtilTest {
	@Test
	public void testUtil() {
		String encoderByMd5 = EncryptUtil.EncoderByMd5("j2ee");
		System.out.println(encoderByMd5);
		String encoderByMd5Double = EncryptUtil.EncoderByMd5("miaoyunchun");
		System.out.println(encoderByMd5Double);
		String encoderByMd5Double2 = EncryptUtil.EncoderByMd5("111");
		System.out.println(encoderByMd5Double2);
		String encoderByMd5Double3 = EncryptUtil.EncoderByMd5("admin");
		System.out.println(encoderByMd5Double3);
		
		String encoderByMd5Double4 = EncryptUtil.EncoderByMd5("ACID");
		System.out.println(encoderByMd5Double4);
		
	}

}
