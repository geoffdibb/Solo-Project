package COM.BAE.BusinessLayer;

public interface KaijuAccountService {

	String getAllKaijuAccounts();

	String createKaijuAccount(String account);

	String deleteKaijuAccount(String account);

	String updateKaijuAccount(String name, String account);

	String getAKaijuAccount(String name);
}
