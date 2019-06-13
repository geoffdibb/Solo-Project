package COM.BAE.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.Collection;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import COM.BAE.PersistenceDomain.FilmData;
import COM.BAE.PersistenceDomain.KaijuAccount;
import COM.BAE.Util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class KaijuAccountDBRepository implements KaijuAccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAllKaijuAccounts() {
		Query query = manager.createQuery("Select a FROM KaijuAccount a");
		Collection<KaijuAccount> kaijuAccounts = (Collection<KaijuAccount>) query.getResultList();
		return util.getJSONForObject(kaijuAccounts);

	}

	@Override
	public String createKaijuAccount(String account) {
		KaijuAccount akaijuAccount = util.getObjectForJSON(account, KaijuAccount.class);
		manager.persist(akaijuAccount);
		return "{\"message\": \"Kaiju has been sucessfully added\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteKaijuAccount(String account) {

		KaijuAccount kaijuAccountInDB = util.getObjectForJSON(getAKaijuAccount(account), KaijuAccount.class);

		if (manager.contains(manager.find(KaijuAccount.class, account))) {

			manager.remove(manager.find(KaijuAccount.class, account));
		}
		return account + " Deleted";
	}

	@Override
	public String updateKaijuAccount(String name) {
		KaijuAccount transAccount = util.getObjectForJSON(name, KaijuAccount.class);

		KaijuAccount oldAccount = manager.find(KaijuAccount.class, name);

		if (oldAccount != null) {

			oldAccount.setName(transAccount.getName());

			manager.persist(oldAccount);

		}

		return "{\"message\": \"Kaiju successfully updated\"}";
	}

	@Override
	public String getAKaijuAccount(String name) {
		return util.getJSONForObject(manager.find(KaijuAccount.class, name));
	}

	@Override
	public String getAllKaijuFilmData() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection<FilmData> filmData = (Collection<FilmData>) query.getResultList();

		return util.getJSONForObject(filmData);
	}

	@Override
	public String createKaijuFilmData(String name) {
		FilmData akaijuFilmdata = util.getObjectForJSON(name, FilmData.class);
		manager.persist(akaijuFilmdata);
		return "{\"message\": \"Kaiju has been sucessfully added\"}";
	}

	@Override
	public String deleteKaijuFilmData(String name) {
		FilmData filmDataInDB = util.getObjectForJSON(getKaijuFilmData(name), FilmData.class);

		if (manager.contains(manager.find(FilmData.class, name))) {

			manager.remove(manager.find(FilmData.class, name));
		}
		return "{\"message\": \"Kaiju successfully deleted\"}";
	}

	@Override
	public String updateKaijuFilmData(String name) {
		FilmData transAccount = util.getObjectForJSON(name, FilmData.class);

		FilmData oldAccount = manager.find(FilmData.class, name);

		if (oldAccount != null) {

			oldAccount.setName(transAccount.getName());

			manager.persist(oldAccount);

		}

		return "{\"message\": \"FilmData successfully updated\"}";
	}

	@Override
	public String getKaijuFilmData(String name) {
		return util.getJSONForObject(manager.find(FilmData.class, name));
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
