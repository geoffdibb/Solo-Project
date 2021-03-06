package COM.BAE.BusinessLayer;

import javax.inject.Inject;

import COM.BAE.persistence.repository.KaijuAccountRepository;

public class KaijuAccountImplementation implements KaijuAccountService {

	@Inject
	KaijuAccountRepository kaijuAccountRepo;

	@Override
	public String getAllKaijuAccounts() {
		return kaijuAccountRepo.getAllKaijuAccounts();
	}

	@Override
	public String createKaijuAccount(String account) {
		return kaijuAccountRepo.createKaijuAccount(account);
	}

	@Override
	public String deleteKaijuAccount(String account) {
		return kaijuAccountRepo.deleteKaijuAccount(account);
	}

	@Override
	public String updateKaijuAccount(String name, String account) {
		return kaijuAccountRepo.updateKaijuAccount(name, account);
	}

	@Override
	public String getAKaijuAccount(String name) {
		return kaijuAccountRepo.getAKaijuAccount(name);
	}

}
