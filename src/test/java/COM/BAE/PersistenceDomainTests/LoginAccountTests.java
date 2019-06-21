package COM.BAE.PersistenceDomainTests;

import org.junit.Assert;
import org.junit.Test;

import COM.BAE.PersistenceDomain.LoginAccount;

public class LoginAccountTests {
	LoginAccount account = new LoginAccount("Zilla", "favekaiju");

	@Test
	public void testGetterName() {

		Assert.assertEquals(account.getUserName(), "Zilla");
	}

	@Test
	public void testSetterName() {
		account.setUserName("Zilla2");
		Assert.assertEquals(account.getUserName(), "Zilla2");
	}
}
