package COM.BAE.BusinessLayer;

public interface KaijuAccountService {

	String getAllKaijuAccounts();

	String createKaijuAccount(String account);

	String deleteKaijuAccount(String name);

	String updateKaijuAccount(String name);

	String getAKaijuAccount(String name);
}
