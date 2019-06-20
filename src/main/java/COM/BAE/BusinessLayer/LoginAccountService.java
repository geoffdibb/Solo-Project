package COM.BAE.BusinessLayer;

public interface LoginAccountService {

	String getALoginAccount(String userName);

	String createLoginAccount(String userName);

	String deleteLoginAccount(String userName);

	String setFaveKaiju(String userName, String account);
}
