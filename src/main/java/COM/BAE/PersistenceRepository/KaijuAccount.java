package COM.BAE.PersistenceRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KaijuAccount {

	@Id
	private String name;
	@Column
	private int height;
	@Column
	private int weight;
	@Column
	private String creatureType;
	@Column
	private String description;

	public KaijuAccount(String name, int height, int weight, String creatureType, String description) {
		super();
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.creatureType = creatureType;
		this.description = description;
	}

	public KaijuAccount() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenus() {
		return creatureType;
	}

	public void setGenus(String genus) {
		this.creatureType = genus;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}