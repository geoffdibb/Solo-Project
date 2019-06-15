package COM.BAE.BusinessLayer;

public interface FilmDataService {

	String getAllKaijuFilmData();

	String createKaijuFilmData(String name);

	String deleteKaijuFilmData(String name);

	String updateKaijuFilmData(String name);

	String getKaijuFilmData(String name);
}
