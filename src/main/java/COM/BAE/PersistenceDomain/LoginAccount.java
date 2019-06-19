package COM.BAE.PersistenceDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LoginAccount {

	@Id
	private String userName;

	@Column
	private String faveKaiju;

	public LoginAccount() {
	}

	public LoginAccount(String userName, String faveKaiju) {
		super();
		this.userName = userName;
		this.faveKaiju = faveKaiju;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFaveKaiju() {
		return faveKaiju;
	}

	public void setFaveKaiju(String faveKaiju) {
		this.faveKaiju = faveKaiju;
	}
}