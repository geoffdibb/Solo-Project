package COM.BAE.BusinessLayer;

import javax.inject.Inject;

import COM.BAE.persistence.repository.FilmDataRepository;

public class FilmDataImplementation implements FilmDataService {

	@Inject
	FilmDataRepository FilmDataRepo;

	@Override
	public String getKaijuFilmData(String name) {
		return FilmDataRepo.getKaijuFilmData(name);
	}

}
