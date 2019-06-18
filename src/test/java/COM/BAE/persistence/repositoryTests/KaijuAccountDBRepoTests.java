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

import COM.BAE.PersistenceDomain.KaijuAccount;
import COM.BAE.Util.JSONUtil;
import COM.BAE.persistence.repository.KaijuAccountDBRepository;

@RunWith(MockitoJUnitRunner.class)
public class KaijuAccountDBRepoTests {

	@InjectMocks
	private KaijuAccountDBRepository repo;

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

	private static final String MOCK_OBJECT = "{\"name\":\"Zilla\",\"height\":15,\"weight\":15,\"creatureType\":\"lizard\",\"description\":\"big lizard\"}";

	@Test
	public void getAllKaijuAccountsTest() {

		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<KaijuAccount> kaiju = new ArrayList<KaijuAccount>();

		kaiju.add(new KaijuAccount("Zilla", 15, 15, "lizard", "big lizard"));

		Mockito.when(query.getResultList()).thenReturn(kaiju);

		// System.out.println(repo.getAllKaijuAccounts());

		Assert.assertEquals(
				"[{\"name\":\"Zilla\",\"height\":15,\"weight\":15,\"creatureType\":\"lizard\",\"description\":\"big lizard\"}]",
				repo.getAllKaijuAccounts());
	}

	@Test
	public void testCreateKaiju() {
		String reply = repo.createKaijuAccount(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Kaiju has been sucessfully added\"}");
	}

	@Test
	public void testDeleteKAiju() {
		String reply = repo.deleteKaijuAccount("Zilla");
		assertTrue(reply.contains("Deleted"));
	}

	private static final KaijuAccount kaiju1 = new KaijuAccount("Zilla", 15, 15, "lizard", "big lizard");

	@Test
	public void testgetakaiju() {
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);

		List<KaijuAccount> kaiju = new ArrayList<KaijuAccount>();

		kaiju.add(new KaijuAccount("Zilla", 15, 15, "lizard", "big lizard"));

		Mockito.when(query.getResultList()).thenReturn(kaiju);
		Mockito.when(manager.find(KaijuAccount.class, "Zilla")).thenReturn(kaiju1);
		System.out.println(repo.getAKaijuAccount("Zilla"));

		Assert.assertEquals(
				"{\"name\":\"Zilla\",\"height\":15,\"weight\":15,\"creatureType\":\"lizard\",\"description\":\"big lizard\"}",
				repo.getAKaijuAccount("Zilla"));

	}
}
