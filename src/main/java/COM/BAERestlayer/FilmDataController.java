package COM.BAERestlayer;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import COM.BAE.BusinessLayer.FilmDataService;

@Path("FilmData")
public class FilmDataController {

	@Inject
	private FilmDataService service;

	@Path("/getAFilmData/{name}")
	@GET
	@Produces({ "application/json" })
	public String getAFilmData(@PathParam("name") String name) {
		return service.getKaijuFilmData(name);
	}

	public void setService(FilmDataService service) {
		this.service = service;
	}

}