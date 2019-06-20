package COM.BAE.persistence.repositoryTests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import COM.BAE.PersistenceDomain.LoginAccount;
import COM.BAE.Util.JSONUtil;
import COM.BAE.persistence.repository.LoginAccountDBRepository;

@RunWith(MockitoJUnitRunner.class)

public class LoginAccountDBRepoTests {

	@InjectMocks
	private LoginAccountDBRepository repo;

	@Mock
	private EntityManager manager;

	// @Mock
	private JSONUtil util;

	@Mock
	private Query query;

	@Before
	public void setup() {
		repo.setManager(manager);
		util = new JSONUtil();
		repo.setUtil(util);
	}

	private static final String MOCK_OBJECT = "{\"userName\":\"Geoff\",\"faveKaiju\":\"Mothra\"}";
	private static final String MOCK_OBJECT2 = "{\"userName\":\"Geoff\",\"faveKaiju\":\"Rodan\"}";

	@Test
	public void testCreateLogin() {
		String reply = repo.createLoginAccount(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Login created\"}");
	}

	@Test
	public void testDeleteLogin() {
		String reply = repo.deleteLoginAccount("Geoff");
		assertTrue(reply.contains("Deleted"));
	}

	private static final LoginAccount login1 = new LoginAccount("Geoff", "Mothra");

	@Test
	public void testgetaLogin() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<LoginAccount> login = new ArrayList<LoginAccount>();

		login.add(new LoginAccount("Geoff", "Mothra"));

		Mockito.when(query.getResultList()).thenReturn(login);
		Mockito.when(manager.find(LoginAccount.class, "Geoff")).thenReturn(login1);

		Assert.assertEquals(MOCK_OBJECT, repo.getALoginAccount("Geoff"));

	}

	@Test
	public void testsetFaveKaiju() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<LoginAccount> login = new ArrayList<LoginAccount>();

		login.add(new LoginAccount("Geoff", "Mothra"));

		Mockito.when(query.getResultList()).thenReturn(login);

		Mockito.when(manager.find(LoginAccount.class, "Geoff")).thenReturn(login1);

		repo.setFaveKaiju("Geoff", MOCK_OBJECT2);

		Assert.assertEquals(MOCK_OBJECT2, repo.getALoginAccount("Geoff"));

	}
}
