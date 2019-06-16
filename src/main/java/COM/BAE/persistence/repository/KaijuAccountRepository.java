package COM.BAE.persistence.repository;

public interface KaijuAccountRepository {

	String getAllKaijuAccounts();

	String createKaijuAccount(String account);

	String deleteKaijuAccount(String acount);

	String updateKaijuAccount(String name, String account);

	String getAKaijuAccount(String name);

}