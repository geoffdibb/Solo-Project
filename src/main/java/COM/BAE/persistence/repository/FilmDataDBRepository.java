package COM.BAE.persistence.repository;

import static javax.transaction.Transactional.TxType.SUPPORTS;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import COM.BAE.PersistenceDomain.FilmData;
import COM.BAE.Util.JSONUtil;

@Transactional(SUPPORTS)
@Default
public class FilmDataDBRepository implements FilmDataRepository {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

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
