package junit;

import com.ibm.emart.user.entity.Buyer;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.ibm.emart.user.service.UserService;

public class UserTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testBuyerSignUp() {
		Buyer buyer = new Buyer();

		buyer.setId(1);

		buyer.setUserName("liuxuanhe");

		buyer.setPassword("aaa");


		buyer.setMobileNumber("13333333333");

		buyer.setEmailId("1111@qq.com");

		Date date = new Date();


		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");

		buyer.setCreatedDatetime(dateFormat.format(date));

		userService.saveBuyer(buyer);
	}
	
}
