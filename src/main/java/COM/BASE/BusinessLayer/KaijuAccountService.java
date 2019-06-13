package COM.BASE.BusinessLayer;

public interface KaijuAccountService {

	String getAllKaijuAccounts();

	String createKaijuAccount(String name);

	String deleteKaijuAccount(String name);

	String updateKaijuAccount(String name);

	String getAKaijuAccount(String name);
}
