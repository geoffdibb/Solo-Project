package COM.BAE.BusinessLayertests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.BusinessLayer.KaijuAccountImplementation;
import COM.BAE.persistence.repository.KaijuAccountRepository;

@RunWith(MockitoJUnitRunner.class)

public class KaijuAccountImplementationtests {

	private static final String MOCK_VALUE2 = "test_value_2";

	private static final String MOCK_VALUE = "Zilla";

	@InjectMocks
	private KaijuAccountImplementation endpoint;

	@Mock
	private KaijuAccountRepository kaijuAccountRepo;

	@Before
	public void setup() {
	}

	@Test
	public void testGetAFilm() {
		Mockito.when(kaijuAccountRepo.getAKaijuAccount("Zilla")).thenReturn(MOCK_VALUE);
		Assert.assertEquals("Zilla", endpoint.getAKaijuAccount("Zilla"));
	}

	@Test
	public void testCreateKaiju() {
		Mockito.when(kaijuAccountRepo.createKaijuAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createKaijuAccount(MOCK_VALUE2));
		Mockito.verify(kaijuAccountRepo).createKaijuAccount(MOCK_VALUE2);
	}

	@Test
	public void testGetAllKaiju() {
		Mockito.when(kaijuAccountRepo.getAllKaijuAccounts()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllKaijuAccounts());
	}

	@Test
	public void testDeleteMovie() {
		Mockito.when(kaijuAccountRepo.deleteKaijuAccount(MOCK_VALUE)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteKaijuAccount(MOCK_VALUE));
		Mockito.verify(kaijuAccountRepo).deleteKaijuAccount(MOCK_VALUE);
	}
}
