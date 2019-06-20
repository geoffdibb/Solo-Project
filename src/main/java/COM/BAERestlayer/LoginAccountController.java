package COM.BAERestlayer;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import COM.BAE.BusinessLayer.LoginAccountService;

@Path("LoginAccount")

public class LoginAccountController {
	@Inject
	private LoginAccountService service;

	@Path("/getLoginAccount/{name}")
	@GET
	@Produces({ "application/json" })
	public String getALoginAccount(@PathParam("name") String account) {
		return service.getALoginAccount(account);
	}

	@Path("/createLoginAccount")
	@POST
	@Produces({ "application/json" })
	public String addALoginAccount(String account) {
		return service.createLoginAccount(account);
	}

	@Path("/deleteLoginAccount/{name}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteLogin(@PathParam("name") String account) {
		return service.deleteLoginAccount(account);
	}

	@Path("/updateLoginAccount/{name}")
	@PUT
	@Produces({ "application/json" })
	public String updateLogin(@PathParam("name") String name, String account) {
		return service.setFaveKaiju(name, account);
	}

	public void setService(LoginAccountService service) {
		this.service = service;
	}

}
