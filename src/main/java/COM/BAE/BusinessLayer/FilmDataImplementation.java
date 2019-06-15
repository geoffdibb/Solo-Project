package COM.BAE.BusinessLayer;

import javax.inject.Inject;

import COM.BAE.persistence.repository.FilmDataRepository;

public class FilmDataImplementation implements FilmDataService {

	@Inject
	FilmDataRepository FilmDataRepo;

	@Override
	public String getAllKaijuFilmData() {
		return FilmDataRepo.getAllKaijuFilmData();
	}

	@Override
	public String createKaijuFilmData(String name) {
		return FilmDataRepo.createKaijuFilmData(name);
	}

	@Override
	public String deleteKaijuFilmData(String name) {
		return FilmDataRepo.deleteKaijuFilmData(name);
	}

	@Override
	public String updateKaijuFilmData(String name) {
		return FilmDataRepo.updateKaijuFilmData(name);
	}

	@Override
	public String getKaijuFilmData(String name) {
		return FilmDataRepo.getKaijuFilmData(name);
	}

}
