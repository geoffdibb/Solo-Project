package COM.BAE.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import COM.BAE.PersistenceDomain.LoginAccount;
import COM.BAE.Util.JSONUtil;

public class LoginAccountDBRepository implements LoginAccountRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	@Override
	public String getALoginAccount(String userName) {
		return util.getJSONForObject(manager.find(LoginAccount.class, userName));
	}

	@Override
	@Transactional(REQUIRED)
	public String createLoginAccount(String userName) {
		LoginAccount useraccount = util.getObjectForJSON(userName, LoginAccount.class);
		manager.persist(useraccount);
		return "{\"message\": \"Login created\"}";
	}

	@Override
	@Transactional(REQUIRED)
	public String deleteLoginAccount(String userName) {
		LoginAccount useraccount = util.getObjectForJSON(getALoginAccount(userName), LoginAccount.class);

		if (manager.contains(manager.find(LoginAccount.class, userName))) {

			manager.remove(manager.find(LoginAccount.class, userName));
		}
		return userName + "Deleted";
	}

	@Override
	public String setFaveKaiju(String userName, String account) {
		LoginAccount transAccount = util.getObjectForJSON(account, LoginAccount.class);
		LoginAccount oldAccount = manager.find(LoginAccount.class, userName);

		if (oldAccount != null) {

			oldAccount.setFaveKaiju(transAccount.getFaveKaiju());

			manager.persist(oldAccount);
		}
		return null;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
