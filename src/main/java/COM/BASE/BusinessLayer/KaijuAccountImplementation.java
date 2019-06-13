package COM.BASE.BusinessLayer;

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
	public String createKaijuAccount(String name) {
		return kaijuAccountRepo.createKaijuAccount(name);
	}

	@Override
	public String deleteKaijuAccount(String name) {
		return kaijuAccountRepo.deleteKaijuAccount(name);
	}

	@Override
	public String updateKaijuAccount(String name) {
		return kaijuAccountRepo.updateKaijuAccount(name);
	}

	@Override
	public String getAKaijuAccount(String name) {
		return kaijuAccountRepo.getAKaijuAccount(name);
	}

}
