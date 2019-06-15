package COM.BAERestlayer;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import COM.BAE.BusinessLayer.FilmDataService;

@Path("FilmData")
public class FilmDataController {

	@Inject
	private FilmDataService service;

	@Path("getAllFilmData")
	@GET
	@Produces({ "application/json" })
	public String getAllFilmData() {
		return service.getAllKaijuFilmData();
	}

	@Path("/getAFilmData/{name}")
	@GET
	@Produces({ "application/json" })
	public String getAFilmData(@PathParam("name") String name) {
		return service.getKaijuFilmData(name);
	}

	@Path("/createKaijuFilmData")
	@POST
	@Produces({ "application/json" })
	public String addAKaijuAccount(String name) {
		return service.createKaijuFilmData(name);
	}

	@Path("/deleteFilmData/{name}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteFilmData(@PathParam("name") String name) {
		return service.deleteKaijuFilmData(name);
	}

	@Path("/updateFilmData/{name}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("name") String name) {
		return service.updateKaijuFilmData(name);
	}

	public void setService(FilmDataService service) {
		this.service = service;
	}

}