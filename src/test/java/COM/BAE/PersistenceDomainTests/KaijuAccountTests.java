package COM.BAE.PersistenceDomainTests;

import org.junit.Assert;
import org.junit.Test;

import COM.BAE.PersistenceDomain.KaijuAccount;

public class KaijuAccountTests {

	KaijuAccount account = new KaijuAccount("Zilla", 1, 1, "Sample", "Sample");

	@Test
	public void testGetterName() {

		Assert.assertEquals(account.getName(), "Zilla");
	}

	@Test
	public void testSetterName() {
		account.setName("Zilla2");
		Assert.assertEquals(account.getName(), "Zilla2");
	}
}
