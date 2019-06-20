package COM.BAE.BusinessLayertests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.BusinessLayer.LoginAccountImplementation;
import COM.BAE.persistence.repository.LoginAccountRepository;

@RunWith(MockitoJUnitRunner.class)

public class LoginAccountImplementationTests {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "Zilla";

	@InjectMocks
	private LoginAccountImplementation endpoint;
	// Class under test

	@Mock
	private LoginAccountRepository LoginAccountRepo;

	@Before
	public void setup() {
	}

	@Test
	public void testGetALogin() {
		Mockito.when(LoginAccountRepo.getALoginAccount("Zilla")).thenReturn(MOCK_VALUE);
		Assert.assertEquals("Zilla", endpoint.getALoginAccount("Zilla"));
	}

	@Test
	public void testCreateLogin() {
		Mockito.when(LoginAccountRepo.createLoginAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createLoginAccount(MOCK_VALUE2));
		Mockito.verify(LoginAccountRepo).createLoginAccount(MOCK_VALUE2);
	}

	@Test
	public void testDeleteLogin() {
		Mockito.when(LoginAccountRepo.deleteLoginAccount(MOCK_VALUE)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteLoginAccount(MOCK_VALUE));
		Mockito.verify(LoginAccountRepo).deleteLoginAccount(MOCK_VALUE);
	}
}
