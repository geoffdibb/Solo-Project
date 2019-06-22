package COM.BAE.BusinessLayertests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.BusinessLayer.FilmDataImplementation;
import COM.BAE.persistence.repository.FilmDataRepository;

@RunWith(MockitoJUnitRunner.class)

public class FilmDataImplementationTests {

	private static final String MOCK_VALUE = "Zilla";

	@InjectMocks
	private FilmDataImplementation endpoint;

	@Mock
	private FilmDataRepository FilmDataRepo;

	@Test
	public void testGetAFilm() {
		Mockito.when(FilmDataRepo.getKaijuFilmData("Zilla")).thenReturn(MOCK_VALUE);
		Assert.assertEquals("Zilla", endpoint.getKaijuFilmData("Zilla"));
	}
}
