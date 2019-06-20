package COM.BAE.persistence.repository;

public interface LoginAccountRepository {

	String getALoginAccount(String userName);

	String createLoginAccount(String userName);

	String deleteLoginAccount(String userName);

	String setFaveKaiju(String name, String account);

}
