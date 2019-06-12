package COM.BAE.persistence.repository;

public interface KaijuAccountRepository {

	String getAllKaijuAccounts();

	String createKaijuAccount(String name);

	String deleteKaijuAccount(String name);

	String updateKaijuAccount(String name);

	String getAKaijuAccount(String name);

	String getAllKaijuFilmData();

	String createKaijuFilmData(String name);

	String deleteKaijuFilmData(String name);

	String updateKaijuFilmData(String name);

	String getKaijuFilmData(String name);
}
