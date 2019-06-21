package COM.BAE.PersistenceDomainTests;

import org.junit.Assert;
import org.junit.Test;

import COM.BAE.PersistenceDomain.FilmData;

public class FilmDataTests {

	FilmData Film = new FilmData("Zilla", 1, "ZillaFilm", 2);

	@Test
	public void testGetterName() {

		Assert.assertEquals(Film.getName(), "Zilla");
	}

	@Test
	public void testGetterFilmNo() {

		Assert.assertEquals(Film.getNoOfFilms(), 1);
	}

	@Test
	public void testGetterFirstFilm() {

		Assert.assertEquals(Film.getFirstFilm(), "ZillaFilm");
	}

	@Test
	public void testGetterWinCount() {

		Assert.assertEquals(Film.getWinCount(), 2);
	}

	@Test
	public void testSetterName() {
		Film.setName("Zilla2");
		Assert.assertEquals(Film.getName(), "Zilla2");
	}

	@Test
	public void testFilmNo() {
		Film.setNoOfFilms(2);
		Assert.assertEquals(Film.getNoOfFilms(), 2);
	}

	@Test
	public void testSetterFirstFilm() {
		Film.setFirstFilm("ZillaFilm2");
		Assert.assertEquals(Film.getFirstFilm(), "ZillaFilm2");
	}

	@Test
	public void testSetterWinCount() {
		Film.setWinCount(3);
		Assert.assertEquals(Film.getWinCount(), 3);
	}
}
