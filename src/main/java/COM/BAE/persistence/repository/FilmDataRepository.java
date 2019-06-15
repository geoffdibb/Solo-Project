package COM.BAE.persistence.repository;

public interface FilmDataRepository {

	String getAllKaijuFilmData();

	String createKaijuFilmData(String name);

	String deleteKaijuFilmData(String name);

	String updateKaijuFilmData(String name);

	String getKaijuFilmData(String name);
}
