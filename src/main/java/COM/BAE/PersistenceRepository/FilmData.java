package COM.BAE.PersistenceRepository;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FilmData {


	@Id
	private String name;
	public FilmData(String name, int noOfFilms, String firstFilm, int winCount) {
		super();
		this.name = name;
		this.noOfFilms = noOfFilms;
		this.firstFilm = firstFilm;
		this.winCount = winCount;
	}
	@Column
	private int noOfFilms;
	@Column
	private String firstFilm;
	@Column
	private int winCount;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoOfFilms() {
		return noOfFilms;
	}
	public void setNoOfFilms(int noOfFilms) {
		this.noOfFilms = noOfFilms;
	}
	public String getFirstFilm() {
		return firstFilm;
	}
	public void setFirstFilm(String firstFilm) {
		this.firstFilm = firstFilm;
	}
	public int getWinCount() {
		return winCount;
	}
	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}
}