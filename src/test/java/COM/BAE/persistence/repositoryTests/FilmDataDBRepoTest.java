package COM.BAE.persistence.repositoryTests;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.PersistenceDomain.FilmData;
import COM.BAE.Util.JSONUtil;
import COM.BAE.persistence.repository.FilmDataDBRepository;

@RunWith(MockitoJUnitRunner.class)

public class FilmDataDBRepoTest {

	@InjectMocks
	private FilmDataDBRepository repo;

	@Mock
	private EntityManager manager;

	private JSONUtil util;

	@Mock
	private Query query;

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	private static final FilmData film1 = new FilmData("Zilla", 15, "lizard", 15);

	@Test
	public void testgetakaiju() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<FilmData> film = new ArrayList<FilmData>();

		film.add(new FilmData("Zilla", 15, "lizard", 15));

		Mockito.when(query.getResultList()).thenReturn(film);
		Mockito.when(manager.find(FilmData.class, "Zilla")).thenReturn(film1);
		System.out.println(repo.getKaijuFilmData("Zilla"));

		Assert.assertEquals("{\"name\":\"Zilla\",\"noOfFilms\":15,\"firstFilm\":\"lizard\",\"winCount\":15}",
				repo.getKaijuFilmData("Zilla"));

	}
}
