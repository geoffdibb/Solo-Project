package COM.BAE.RRestlayertests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.BusinessLayer.LoginAccountService;
import COM.BAERestlayer.LoginAccountController;

@RunWith(MockitoJUnitRunner.class)

public class LoginAccountControllerTests {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "Zilla";

	@InjectMocks
	private LoginAccountController endpoint;
	// Class under test

	@Mock
	private LoginAccountService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetALogin() {
		Mockito.when(service.getALoginAccount("Zilla")).thenReturn(MOCK_VALUE);
		Assert.assertEquals("Zilla", endpoint.getALoginAccount("Zilla"));
	}

	@Test
	public void testCreateLogin() {
		Mockito.when(service.createLoginAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.addALoginAccount(MOCK_VALUE2));
		Mockito.verify(service).createLoginAccount(MOCK_VALUE2);
	}

	@Test
	public void testDeleteLogin() {
		Mockito.when(service.deleteLoginAccount(MOCK_VALUE)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteLogin(MOCK_VALUE));
		Mockito.verify(service).deleteLoginAccount(MOCK_VALUE);
	}
}
