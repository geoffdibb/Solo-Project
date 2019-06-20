package COM.BAE.RRestlayertests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.BusinessLayer.FilmDataService;
import COM.BAERestlayer.FilmDataController;

@RunWith(MockitoJUnitRunner.class)

public class FilmDataControllerTests {

	private static final String MOCK_VALUE = "Zilla";

	@InjectMocks
	private FilmDataController endpoint;
	// Class under test

	@Mock
	private FilmDataService service;

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void testGetAFilm() {
		Mockito.when(service.getKaijuFilmData("Zilla")).thenReturn(MOCK_VALUE);
		Assert.assertEquals("Zilla", endpoint.getAFilmData("Zilla"));
	}
}
