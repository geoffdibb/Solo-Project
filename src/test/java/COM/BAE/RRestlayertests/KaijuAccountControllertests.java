package COM.BAE.RRestlayertests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.BusinessLayer.KaijuAccountService;
import COM.BAERestlayer.KaijuAccountController;

@RunWith(MockitoJUnitRunner.class)

public class KaijuAccountControllertests {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "Zilla";

	@InjectMocks
	private KaijuAccountController endpoint;
	// Class under test

	@Mock
	private KaijuAccountService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetAFilm() {
		Mockito.when(service.getAKaijuAccount("Zilla")).thenReturn(MOCK_VALUE);
		Assert.assertEquals("Zilla", endpoint.getAnAccount("Zilla"));
	}

	@Test
	public void testCreateKaiju() {
		Mockito.when(service.createKaijuAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.addAKaijuAccount(MOCK_VALUE2));
		Mockito.verify(service).createKaijuAccount(MOCK_VALUE2);
	}

	@Test
	public void testGetAllKaiju() {
		Mockito.when(service.getAllKaijuAccounts()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllKaijuAccounts());
	}

	@Test
	public void testDeleteMovie() {
		Mockito.when(service.deleteKaijuAccount(MOCK_VALUE)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteAccount(MOCK_VALUE));
		Mockito.verify(service).deleteKaijuAccount(MOCK_VALUE);
	}

}