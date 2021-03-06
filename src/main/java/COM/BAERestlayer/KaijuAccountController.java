package COM.BAERestlayer;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import COM.BAE.BusinessLayer.KaijuAccountService;

@Path("kaijuAccount")
public class KaijuAccountController {

	@Inject
	private KaijuAccountService service;

	@Path("getAllKaijuAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllKaijuAccounts() {
		return service.getAllKaijuAccounts();
	}

	@Path("/getAKaijuAccount/{name}")
	@GET
	@Produces({ "application/json" })
	public String getAnAccount(@PathParam("name") String account) {
		return service.getAKaijuAccount(account);
	}

	@Path("/createKaijuAccount")
	@POST
	@Produces({ "application/json" })
	public String addAKaijuAccount(String name) {
		return service.createKaijuAccount(name);
	}

	@Path("/deleteKaijuAccount/{name}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("name") String account) {
		return service.deleteKaijuAccount(account);
	}

	@Path("/updateKaijuAccount/{name}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("name") String name, String account) {
		return service.updateKaijuAccount(name, account);
	}

	public void setService(KaijuAccountService service) {
		this.service = service;
	}

}