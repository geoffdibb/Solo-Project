package COM.BAE.BusinessLayer;

import javax.inject.Inject;

import COM.BAE.persistence.repository.LoginAccountRepository;

public class LoginAccountImplementation implements LoginAccountService {

	@Inject
	LoginAccountRepository LoginAccountRepo;

	@Override
	public String getALoginAccount(String userName) {
		return LoginAccountRepo.getALoginAccount(userName);
	}

	@Override
	public String createLoginAccount(String userName) {
		return LoginAccountRepo.createLoginAccount(userName);
	}

	@Override
	public String deleteLoginAccount(String userName) {
		return LoginAccountRepo.deleteLoginAccount(userName);
	}

	@Override
	public String setFaveKaiju(String userName, String account) {
		return LoginAccountRepo.setFaveKaiju(userName, account);
	}

}
